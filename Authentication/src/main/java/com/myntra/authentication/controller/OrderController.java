package com.myntra.authentication.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myntra.authentication.common.APIResponse;
import com.myntra.authentication.service.JwtTokenService;
import com.myntra.authentication.service.OrderService;


@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {
	private OrderService orderService;
	private JwtTokenService jwtTokenService;

	public OrderController(OrderService orderService,JwtTokenService jwtTokenService) {
		super();
		this.orderService = orderService;
		this.jwtTokenService = jwtTokenService;
	}
	
	@PostMapping("/checkout")
	public APIResponse placeOrder(@RequestHeader("Authorization") String jwtToken,@RequestBody Object order) {
		Long userId = jwtTokenService.getUserId(jwtToken.substring(7));
		return orderService.placeOrder(userId,order);
	}
	
	@GetMapping("/details/{orderId}")
	public APIResponse viewOrder(@RequestHeader("Authorization") String jwtToken,@PathVariable Long orderId) {
		jwtTokenService.validateToken(jwtToken.substring(7));
		return orderService.viewOrder(orderId);
	}

}
