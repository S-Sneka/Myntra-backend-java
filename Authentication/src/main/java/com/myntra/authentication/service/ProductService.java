package com.myntra.authentication.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.myntra.authentication.common.APIResponse;
import com.myntra.authentication.config.UrlConfiguration;

@Service
public class ProductService {
	
	private UrlConfiguration urlConfiguration;
	private RestTemplate restTemplate = new RestTemplateBuilder().build();
	private APIResponse apiResponse;
	private String url;

	public ProductService(UrlConfiguration urlConfiguration) {
		super();
		this.urlConfiguration = urlConfiguration;
	}

	public APIResponse sendProducts(Long userId, Long categoryId) {
		url = urlConfiguration.getProduct()+"/all/"+userId+"/"+categoryId;
		apiResponse = restTemplate.getForObject(url, APIResponse.class);
		return apiResponse;
	}

	public APIResponse sendProductsM(Long userId, Long categoryId) {
		url = urlConfiguration.getProduct()+"/allm/"+userId+"/"+categoryId;
		apiResponse = restTemplate.getForObject(url, APIResponse.class);
		return apiResponse;
	}

	public APIResponse sendProduct(Long userId, Long productId) {
		url = urlConfiguration.getProduct()+"/"+userId+"/"+productId;
		apiResponse = restTemplate.getForObject(url, APIResponse.class);
		return apiResponse;
	}

}
