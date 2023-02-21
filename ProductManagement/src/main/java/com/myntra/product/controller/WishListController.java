package com.myntra.product.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myntra.product.common.APIResponse;
import com.myntra.product.dto.AlterBagDto;
import com.myntra.product.dto.AlterWishDto;
import com.myntra.product.dto.ListAlterWishDto;
import com.myntra.product.service.WishListService;


@CrossOrigin
@RestController
@RequestMapping("/wishlist")
public class WishListController {

	private WishListService wishListService;
	
	public WishListController(WishListService wishListService) {
		super();
		this.wishListService = wishListService;
	}
	
	@PostMapping("/add/{userId}")
	public APIResponse addToWish(@RequestBody AlterWishDto wish,@PathVariable Long userId) {
		return wishListService.addToWish(userId,wish);
	}
	
	@PostMapping("/move/{userId}")
	public APIResponse moveToWish(@RequestBody AlterBagDto wish,@PathVariable Long userId) {
		return wishListService.moveToWish(userId,wish);
	}
	
	@GetMapping("/{userId}")
	public APIResponse getWishList(@PathVariable Long userId) {
		return wishListService.getWishList(userId);
	}
	
	@DeleteMapping("/{userId}")
	public APIResponse removeFromWishList(@RequestBody ListAlterWishDto wish,@PathVariable Long userId) {
		return wishListService.removeFromWishList(userId,wish);
	}
}
