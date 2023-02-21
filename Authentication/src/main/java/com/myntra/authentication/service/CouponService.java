package com.myntra.authentication.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.myntra.authentication.common.APIResponse;
import com.myntra.authentication.config.UrlConfiguration;

@Service
public class CouponService {
	
	private UrlConfiguration urlConfiguration;
	private RestTemplate restTemplate = new RestTemplateBuilder().build();
	String url;
	
	public CouponService(UrlConfiguration urlConfiguration) {
		super();
		this.urlConfiguration = urlConfiguration;
	}

	public APIResponse getCoupons() {
		url = urlConfiguration.getCoupon()+"/all";
		APIResponse result = restTemplate.getForObject(url, APIResponse.class);
		return result;
	}

}
