package com.myntra.authentication.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.myntra.authentication.common.APIResponse;
import com.myntra.authentication.config.UrlConfiguration;

@Service
public class WishListService {
	
	private UrlConfiguration urlConfiguration;
	private RestTemplate restTemplate = new RestTemplateBuilder().build();
	private APIResponse apiResponse;
	String url;
	

	public WishListService(UrlConfiguration urlConfiguration,APIResponse apiResponse) {
		super();
		this.urlConfiguration = urlConfiguration;
		this.apiResponse = apiResponse;
	}

	public APIResponse addToWish(Long userId, Object wish) {
		url = urlConfiguration.getWishlist()+"/add/"+userId;
		APIResponse result = restTemplate.postForObject(url, wish, APIResponse.class);
		return result;
	}

	public APIResponse moveToWish(Long userId, Object wish) {
		url = urlConfiguration.getWishlist()+"/move/"+userId;
		APIResponse result = restTemplate.postForObject(url, wish, APIResponse.class);
		return result;
	}

	public APIResponse getWishList(Long userId) {
		url = urlConfiguration.getWishlist()+"/"+userId;
		APIResponse result = restTemplate.getForObject(url, APIResponse.class);
		return result;
	}

	public APIResponse removeFromWishList(Long userId, Object wish) {
		url = urlConfiguration.getWishlist()+"/"+userId;
		restTemplate.delete(url, wish);
		apiResponse.setData(null);
		apiResponse.setMessage("Removed from wish list");
		apiResponse.setStatus(true);
		return apiResponse;
	}

}
