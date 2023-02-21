package com.myntra.order.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.myntra.order.common.APIResponse;
import com.myntra.order.config.UrlConfiguration;
import com.myntra.order.dto.TrackOrder;
import com.myntra.order.entity.Item;
import com.myntra.order.repository.ItemRepository;

@Service
public class ItemService {
	
	private ItemRepository itemRepo;
	private APIResponse apiResponse;
	private UrlConfiguration urlConfig;
	private RestTemplate restTemplate = new RestTemplateBuilder().build();
	private String url;
	private TrackOrder trackOrder;
	
	public ItemService(ItemRepository itemRepo, APIResponse apiResponse, UrlConfiguration urlConfig,
			TrackOrder trackOrder) {
		super();
		this.itemRepo = itemRepo;
		this.apiResponse = apiResponse;
		this.urlConfig = urlConfig;
		this.trackOrder = trackOrder;
	}

	@SuppressWarnings("deprecation")
	public APIResponse trackItem(Long itemId) {
		Item item = itemRepo.findById(itemId).orElse(null);
		trackOrder.setDeliveredAt((item.getDeliveredAt()!=null)?item.getDeliveredAt().toLocaleString():null);
		trackOrder.setDispatchedAt((item.getDispatchedAt()!=null)?item.getDispatchedAt().toLocaleString():null);
		trackOrder.setOrderedAt(item.getOrderedAt().toLocaleString());
		trackOrder.setShippedAt((item.getShippedAt()!=null)?item.getShippedAt().toLocaleString():null);
		trackOrder.setProductDetails(getProductDetails(item.getProductId()));
		trackOrder.setStatus(item.getStatus());
		apiResponse.setData(trackOrder);
		apiResponse.setMessage(null);
		apiResponse.setStatus(true);
		return apiResponse;
	}
	
	public Object getProductDetails(Long productId) {
		url = urlConfig.getProduct()+"/details/"+productId;
		APIResponse result = restTemplate.getForObject(url, APIResponse.class);
		return result.getData();
	}
}
