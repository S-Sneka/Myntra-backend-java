package com.myntra.product.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myntra.product.common.APIResponse;
import com.myntra.product.service.ProductService;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {
	
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@GetMapping("/all/{userId}/{categoryId}")
	public APIResponse sendProducts(@PathVariable Long userId,@PathVariable Long categoryId) {
		return productService.sendProducts(userId,categoryId);
	}
	
	@GetMapping("/allm/{userId}/{categoryId}")
	public APIResponse sendProductsM(@PathVariable Long userId,@PathVariable Long categoryId) {
		return productService.sendProductsM(userId,categoryId);	
	}
	
	@GetMapping("/{userId}/{productId}")
	public APIResponse sendProduct(@PathVariable Long userId,@PathVariable Long productId) {
		return productService.sendProduct(userId,productId);
	}

	@GetMapping("/details/{productId}") //order management
	public APIResponse sendProducts(@PathVariable Long productId) {
		return productService.sendProductDetails(productId);
	}
	
}
