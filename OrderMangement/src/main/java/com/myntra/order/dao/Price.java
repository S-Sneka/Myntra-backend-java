package com.myntra.order.dao;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Price {
	private Map<String,Long> items;
	private Long discount;
	private Long couponDiscount;
	private Long totalPaid;
	public Map<String, Long> getItems() {
		return items;
	}
	public void setItems(Map<String, Long> items) {
		this.items = items;
	}
	public Long getDiscount() {
		return discount;
	}
	public void setDiscount(Long discount) {
		this.discount = discount;
	}
	public Long getCouponDiscount() {
		return couponDiscount;
	}
	public void setCouponDiscount(Long couponDiscount) {
		this.couponDiscount = couponDiscount;
	}
	public Long getTotalPaid() {
		return totalPaid;
	}
	public void setTotalPaid(Long totalPaid) {
		this.totalPaid = totalPaid;
	}
}
