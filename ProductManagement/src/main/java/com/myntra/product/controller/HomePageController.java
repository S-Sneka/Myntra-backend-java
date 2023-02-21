package com.myntra.product.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myntra.product.common.APIResponse;
import com.myntra.product.service.HomePageService;

@CrossOrigin
@RestController
@RequestMapping("/home")
public class HomePageController {
	
	private HomePageService homePageService;
	
	public HomePageController(HomePageService homePageService) {
		super();
		this.homePageService = homePageService;
	}
	
	@GetMapping("/categories")
	public APIResponse sendCategories() {
		return homePageService.sendCategories();
	}
	
	@GetMapping("/categoriesm")
	public APIResponse sendCategoriesM() {
		return homePageService.sendCategoriesM();
	}
	
	@GetMapping("/shopbycategoriesm")
	public APIResponse shopByCategoriesM() {
		return homePageService.shopByCategoriesM();
	}
	
	@GetMapping("/collection")
	public APIResponse sendHomePage() {
		return homePageService.sendHomePage();
	}
}
