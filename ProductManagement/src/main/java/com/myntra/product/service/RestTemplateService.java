package com.myntra.product.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.myntra.product.config.UrlConfiguration;

@Service
public class RestTemplateService {
	private RestTemplate restTemplate = new RestTemplateBuilder().build();
	private UrlConfiguration urlConfig;
	
	public RestTemplateService(UrlConfiguration urlConfig) {
		super();
		this.urlConfig = urlConfig;
	}

	public Long getDefaultAddressId(Long userId) {
		String url = urlConfig.getAddress()+"/default/"+userId;
		Long result = (long)restTemplate.getForObject(url, Long.class);
		return result;
	}

}
