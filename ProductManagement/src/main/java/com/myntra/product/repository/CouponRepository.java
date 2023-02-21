package com.myntra.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myntra.product.entity.Coupon;


public interface CouponRepository extends JpaRepository<Coupon, Long>{
	
	@Query("SELECT c.couponId FROM Coupon c where c.minimumPurchase<=:mrp order by c.discountPercentage desc limit 1")
	Long findValidCoupon(@Param(value = "mrp") Long mrp);
}
