package com.myntra.order.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myntra.order.common.APIResponse;
import com.myntra.order.entity.Order;
import com.myntra.order.service.OrderService;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {
	private OrderService orderService;

	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}
	
	@PostMapping("/checkout/{userId}")
	public APIResponse placeOrder(@RequestBody Order order,@PathVariable Long userId) {
		order.setUserId(userId);
		return orderService.placeOrder(order);
	}
	
	@GetMapping("details/{userId}")
	public APIResponse getCurrentOrders(@PathVariable Long userId) {
		return orderService.getCurrentOrders(userId);
	}

}
