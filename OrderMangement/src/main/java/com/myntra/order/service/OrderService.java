package com.myntra.order.service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.myntra.order.Status;
import com.myntra.order.common.APIResponse;
import com.myntra.order.config.UrlConfiguration;
import com.myntra.order.dto.CurrentOrders;
import com.myntra.order.dto.OrderedProductDto;
import com.myntra.order.entity.Item;
import com.myntra.order.entity.Order;
import com.myntra.order.repository.OrderRepository;

@Service
public class OrderService {
	
	private OrderRepository orderRepo;
	private APIResponse apiResponse;
	private UrlConfiguration urlConfig;
	private CurrentOrders currentOrders;
	private RestTemplate restTemplate = new RestTemplateBuilder().build();
	String url;
	
	public OrderService(OrderRepository orderRepo,APIResponse apiResponse,UrlConfiguration urlConfig,CurrentOrders currentOrders) {
		super();
		this.orderRepo = orderRepo;
		this.apiResponse = apiResponse;
		this.urlConfig = urlConfig;
		this.currentOrders = currentOrders;
	}

	public APIResponse placeOrder(Order order) {
		List<Item> items = order.getItems();
		Long orderId = orderRepo.findOrderId();
		for(Item i:items) {
			i.setStatus(Status.CONFIRMED);
			i.setOrderId(orderId);
		}
		order.setCurrentOrder(true);
		orderRepo.save(order);
		apiResponse.setData(null);
		apiResponse.setMessage("Order placed");
		apiResponse.setStatus(true);
		return apiResponse;
	}
	
	public APIResponse getCurrentOrders(Long orderId) {
		Order order = orderRepo.findById(orderId).orElse(null);
		List<Item> items = order.getItems();
		List<OrderedProductDto> listOfItems = new LinkedList<>();  
		for(Item i:items) {
			Long productId = i.getProductId();
			OrderedProductDto products = new OrderedProductDto();
			products.setProductDetails(getProductDetails(productId));
			products.setItemId(i.getItemId());
			products.setSize(i.getSize());
			products.setStatus(i.getStatus());
			listOfItems.add(products);
		}
		currentOrders.setUserDetails(getUserDetails(order.getUserId(),order.getAddressId()));
		currentOrders.setOrderNo(order.getOrderId());
		currentOrders.setItemsInThisOrder(listOfItems);
		currentOrders.setPaymentMode(order.getPaymentMode());
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");  
	    String strDate = formatter.format(order.getOrderedAt()); 
		currentOrders.setPlacedOn(strDate);
		currentOrders.setTotal(order.getTotal());
		apiResponse.setData(currentOrders);
		apiResponse.setMessage("Order");
		apiResponse.setStatus(true);
		return apiResponse;
	}
	
	public Object getProductDetails(Long productId) {
		url = urlConfig.getProduct()+"/details/"+productId;
		APIResponse result = restTemplate.getForObject(url, APIResponse.class);
		return result.getData();
	}
	
	public Object getUserDetails(Long userId,Long addrId) {
		url = urlConfig.getProfile()+"/details/"+userId+"/"+addrId;
		APIResponse result = restTemplate.getForObject(url, APIResponse.class);
		return result.getData();
	}

}
