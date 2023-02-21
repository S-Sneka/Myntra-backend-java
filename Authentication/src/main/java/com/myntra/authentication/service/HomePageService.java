package com.myntra.authentication.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.myntra.authentication.common.APIResponse;
import com.myntra.authentication.config.UrlConfiguration;

@Service
public class HomePageService {
	
	private UrlConfiguration urlConfiguration;
	private RestTemplate restTemplate = new RestTemplateBuilder().build();
	private APIResponse result;
	private String url;
	

	public HomePageService(UrlConfiguration urlConfiguration) {
		super();
		this.urlConfiguration = urlConfiguration;
	}

	public APIResponse sendCategories() {
		url = urlConfiguration.getHome()+"/categories";
		result = restTemplate.getForObject(url, APIResponse.class);
		return result;
	}

	public APIResponse sendCategoriesM() {
		url = urlConfiguration.getHome()+"/categoriesm";
		result = restTemplate.getForObject(url, APIResponse.class);
		return result;
	}

	public APIResponse shopByCategoriesM() {
		url = urlConfiguration.getHome()+"/shopbycategoriesm";
		result = restTemplate.getForObject(url, APIResponse.class);
		return result;
	}

	public APIResponse sendHomePage() {
		url = urlConfiguration.getHome()+"/collection";
		result = restTemplate.getForObject(url, APIResponse.class);
		return result;
	}

}
