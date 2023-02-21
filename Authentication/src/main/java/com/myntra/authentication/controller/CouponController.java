package com.myntra.authentication.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myntra.authentication.common.APIResponse;
import com.myntra.authentication.service.CouponService;

@CrossOrigin
@RestController
@RequestMapping("/coupons")
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
