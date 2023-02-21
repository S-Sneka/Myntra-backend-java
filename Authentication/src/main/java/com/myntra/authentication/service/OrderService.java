package com.myntra.authentication.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.myntra.authentication.common.APIResponse;
import com.myntra.authentication.config.UrlConfiguration;

@Service
public class OrderService {
	
	private UrlConfiguration urlConfiguration;
	private RestTemplate restTemplate = new RestTemplateBuilder().build();
	private APIResponse result;
	private String url;
	
	public OrderService(UrlConfiguration urlConfiguration) {
		super();
		this.urlConfiguration = urlConfiguration;
	}

	public APIResponse placeOrder(Long userId,Object order) {
		url = urlConfiguration.getOrder()+"/checkout/"+userId;
		result = restTemplate.postForObject(url, order, APIResponse.class);
		return result;
	}


	public APIResponse viewOrder(Long orderId) {
		url = urlConfiguration.getOrder()+"/details/"+orderId;
		result = restTemplate.getForObject(url, APIResponse.class);
		return result;
	}

}
