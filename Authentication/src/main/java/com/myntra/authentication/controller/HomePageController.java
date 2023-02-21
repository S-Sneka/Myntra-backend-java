package com.myntra.authentication.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myntra.authentication.common.APIResponse;
import com.myntra.authentication.service.HomePageService;
import com.myntra.authentication.service.JwtTokenService;


@CrossOrigin
@RestController
@RequestMapping("/home")
public class HomePageController {
	
	private HomePageService homePageService;
	private JwtTokenService jwtTokenService;
	
	public HomePageController(HomePageService homePageService,JwtTokenService jwtTokenService) {
		super();
		this.homePageService = homePageService;
		this.jwtTokenService = jwtTokenService;
	}
	
	@GetMapping("/categories")
	public APIResponse sendCategories(@RequestHeader("Authorization") String jwtToken) {
		if(!jwtToken.equals("")) {
			jwtTokenService.validateToken(jwtToken.substring(7));
		}
		return homePageService.sendCategories();
	}
	
	@GetMapping("/categoriesm")
	public APIResponse sendCategoriesM(@RequestHeader("Authorization") String jwtToken) {
		if(!jwtToken.equals("")) {
			jwtTokenService.validateToken(jwtToken.substring(7));
		}
		return homePageService.sendCategoriesM();
	}
	
	@GetMapping("/shopbycategoriesm")
	public APIResponse shopByCategoriesM(@RequestHeader("Authorization") String jwtToken) {
		if(!jwtToken.equals("")) {
			jwtTokenService.validateToken(jwtToken.substring(7));
		}
		return homePageService.shopByCategoriesM();
	}
	
	@GetMapping("/collection")
	public APIResponse sendHomePage(@RequestHeader("Authorization") String jwtToken) {
		if(!jwtToken.equals("")) {
			jwtTokenService.validateToken(jwtToken.substring(7));
		}
		return homePageService.sendHomePage();
	}
}
