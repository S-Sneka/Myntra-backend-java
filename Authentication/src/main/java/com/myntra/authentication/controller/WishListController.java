package com.myntra.authentication.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myntra.authentication.common.APIResponse;
import com.myntra.authentication.service.JwtTokenService;
import com.myntra.authentication.service.WishListService;


@CrossOrigin
@RestController
@RequestMapping("/wishlist")
public class WishListController {

	private WishListService wishListService;
	private JwtTokenService jwtTokenService;
	private Long userId;

	public WishListController(WishListService wishListService,JwtTokenService jwtTokenService) {
		super();
		this.wishListService = wishListService;
		this.jwtTokenService = jwtTokenService;
	}
	
	@PostMapping("/add")
	public APIResponse addToWish(@RequestBody Object wish,@RequestHeader("Authorization") String jwtToken) {
		userId = jwtTokenService.getUserId(jwtToken.substring(7));
		return wishListService.addToWish(userId,wish);
	}
	
	@PostMapping("/move")
	public APIResponse moveToWish(@RequestBody Object wish,@RequestHeader("Authorization") String jwtToken) {
		userId = jwtTokenService.getUserId(jwtToken.substring(7));
		return wishListService.moveToWish(userId,wish);
	}
	
	@GetMapping()
	public APIResponse getWishList(@RequestHeader("Authorization") String jwtToken) {
		userId = jwtTokenService.getUserId(jwtToken.substring(7));
		return wishListService.getWishList(userId);
	}
	
	@DeleteMapping()
	public APIResponse removeFromWishList(@RequestBody Object wish,@RequestHeader("Authorization") String jwtToken) {
		userId = jwtTokenService.getUserId(jwtToken.substring(7));
		return wishListService.removeFromWishList(userId,wish);
	}
}
