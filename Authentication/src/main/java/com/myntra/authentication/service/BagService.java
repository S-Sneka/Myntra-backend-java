package com.myntra.authentication.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.myntra.authentication.common.APIResponse;
import com.myntra.authentication.config.UrlConfiguration;

@Service
public class BagService {
	private UrlConfiguration urlConfiguration;
	private RestTemplate restTemplate = new RestTemplateBuilder().build();
	private APIResponse apiResponse;
	private String url;
	

	public BagService(UrlConfiguration urlConfiguration,APIResponse apiResponse) {
		super();
		this.urlConfiguration = urlConfiguration;
		this.apiResponse = apiResponse;
	}
	
	public APIResponse addToBag(Long userId, Object bag) {
		url = urlConfiguration.getBag()+"/add/"+userId;
		apiResponse = restTemplate.postForObject(url, bag, APIResponse.class);
		return apiResponse;
	}

	public APIResponse moveToBag(Long userId, Object bag) {
		url = urlConfiguration.getBag()+"/move/"+userId;
		apiResponse = restTemplate.postForObject(url, bag, APIResponse.class);
		return apiResponse;
	}

	public APIResponse getBag(Long userId) {
		url = urlConfiguration.getBag()+"/"+userId;
		apiResponse = restTemplate.getForObject(url, APIResponse.class);
		return apiResponse;
	}

	public APIResponse removeFromBag(Long userId, Object bag) {
		url = urlConfiguration.getBag()+"/"+userId;
		apiResponse = restTemplate.postForObject(url, bag, APIResponse.class);
		return apiResponse;
	}

	public APIResponse editBag(Long userId, Object bag) {
		url = urlConfiguration.getBag()+"/"+userId;
		restTemplate.put(url, bag);
		apiResponse.setData(null);
		apiResponse.setMessage("Edited successfully");
		apiResponse.setStatus(true);
		return apiResponse;
	}

}







