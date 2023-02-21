package com.myntra.addData.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myntra.addData.Entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long>{

}
