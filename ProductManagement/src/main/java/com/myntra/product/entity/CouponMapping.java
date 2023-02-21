package com.myntra.product.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="couponMapping")
public class CouponMapping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Long couponId;
	
	@Column
	private Long userId;
	
	@Column
	private Long totalMRP;
	
	@Column
	private Long discountOnMRP;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCouponId() {
		return couponId;
	}

	public void setCouponId(Long couponId) {
		this.couponId = couponId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getTotalMRP() {
		return totalMRP;
	}

	public void setTotalMRP(Long totalMRP) {
		if(totalMRP<0)
			totalMRP = (long)0;
		this.totalMRP = totalMRP;
	}

	public Long getDiscountOnMRP() {
		return discountOnMRP;
	}

	public void setDiscountOnMRP(Long discountOnMRP) {
		if(discountOnMRP<0)
			discountOnMRP = (long)0;
		this.discountOnMRP = discountOnMRP;
	}

}
