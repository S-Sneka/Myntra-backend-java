package com.myntra.addData.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="coupon")
public class Coupon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long couponId;
	
	@Column
	private String couponCode;
	
	@Column
	private Long minimumPurchase;
	
	@Column
	private int discountPercentage;
	
	@Column
	private LocalDate expiryDate;
	
	@Column
	private LocalTime expiryTime;

	public Long getCouponId() {
		return couponId;
	}

	public void setCouponId(Long couponId) {
		this.couponId = couponId;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public Long getMinimumPurchase() {
		return minimumPurchase;
	}

	public void setMinimumPurchase(Long minimumPurchase) {
		this.minimumPurchase = minimumPurchase;
	}

	public int getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(int discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public LocalTime getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(LocalTime expiryTime) {
		this.expiryTime = expiryTime;
	}

}
