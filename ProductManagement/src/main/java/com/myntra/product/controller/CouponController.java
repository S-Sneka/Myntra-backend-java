package com.myntra.product.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.myntra.product.common.APIResponse;
import com.myntra.product.service.CouponService;

@CrossOrigin
@RestController
@RequestMapping("/coupon")
public class CouponController {
	
	private CouponService couponService;
	
	public CouponController(CouponService couponService) {
		super();
		this.couponService = couponService;
	}

	@GetMapping("/all")
	public APIResponse getCoupons() {
		return couponService.getCoupons();
	}

}
