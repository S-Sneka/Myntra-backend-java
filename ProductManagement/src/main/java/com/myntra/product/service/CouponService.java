package com.myntra.product.service;

import org.springframework.stereotype.Service;

import com.myntra.product.common.APIResponse;
import com.myntra.product.repository.CouponRepository;

@Service
public class CouponService {
	
	private APIResponse apiResponse;
	private CouponRepository couponRepo;
	
	public CouponService(APIResponse apiResponse, CouponRepository couponRepo) {
		super();
		this.apiResponse = apiResponse;
		this.couponRepo = couponRepo;
	}

	public APIResponse getCoupons() {
		apiResponse.setData(couponRepo.findAll());
		apiResponse.setMessage("Coupons");
		apiResponse.setStatus(true);
		return apiResponse;
	}

}
