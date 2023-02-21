package com.myntra.authentication.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myntra.authentication.common.APIResponse;
import com.myntra.authentication.service.JwtTokenService;
import com.myntra.authentication.service.ProductService;


@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {
	
	private ProductService productService;
	private JwtTokenService jwtTokenService;
	private Long userId;
	
	public ProductController(ProductService productService, JwtTokenService jwtTokenService) {
		super();
		this.productService = productService;
		this.jwtTokenService = jwtTokenService;
	}

	@GetMapping("/all/{categoryId}")
	public APIResponse sendProducts(@RequestHeader("Authorization") String jwtToken,@PathVariable Long categoryId) {
		if(!jwtToken.equals(""))
			userId = jwtTokenService.getUserId(jwtToken.substring(7));
		else
			userId = (long)0;
		return productService.sendProducts(userId,categoryId);
	}
	
	@GetMapping("/allm/{categoryId}")
	public APIResponse sendProductsM(@RequestHeader("Authorization") String jwtToken,@PathVariable Long categoryId) {
		if(!jwtToken.equals(""))
			userId = jwtTokenService.getUserId(jwtToken.substring(7));
		else
			userId = (long)0;
		return productService.sendProductsM(userId,categoryId);	
	}
	
	@GetMapping("/{id}")
	public APIResponse sendProduct(@RequestHeader("Authorization") String jwtToken,@PathVariable Long id) {
		if(!jwtToken.equals(""))
			userId = jwtTokenService.getUserId(jwtToken.substring(7));
		else
			userId = (long)0;
		return productService.sendProduct(userId,id);
	}
}
