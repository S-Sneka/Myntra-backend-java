package com.myntra.product.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.myntra.product.dao.BagDao;
import com.myntra.product.entity.Coupon;

@Component
public class BagViewDto {
	private List<BagDao> items;
	private Long selectedItemsCount;
	private Long itemsCount;
	private Coupon coupon;
	private Long totalMrp;
	private Long discountOnMrp;
	private Long couponDiscount;
	private Long convenienceFee;
	private Long totalAmount;
	private Object address;
	public Object getAddress() {
		return address;
	}
	public void setAddress(Object address) {
		this.address = address;
	}
	public List<BagDao> getItems() {
		return items;
	}
	public void setItems(List<BagDao> items) {
		this.items = items;
	}
	public Long getSelectedItemsCount() {
		return selectedItemsCount;
	}
	public void setSelectedItemsCount(Long selectedItemsCount) {
		this.selectedItemsCount = selectedItemsCount;
	}
	public Long getItemsCount() {
		return itemsCount;
	}
	public void setItemsCount(Long itemsCount) {
		this.itemsCount = itemsCount;
	}
	public Coupon getCoupon() {
		return coupon;
	}
	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}
	public Long getTotalMrp() {
		return totalMrp;
	}
	public void setTotalMrp(Long totalMrp) {
		this.totalMrp = totalMrp;
	}
	public Long getDiscountOnMrp() {
		return discountOnMrp;
	}
	public void setDiscountOnMrp(Long discountOnMrp) {
		this.discountOnMrp = discountOnMrp;
	}
	public Long getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Long getCouponDiscount() {
		return couponDiscount;
	}
	public void setCouponDiscount(Long couponDiscount) {
		this.couponDiscount = couponDiscount;
	}
	public Long getConvenienceFee() {
		return convenienceFee;
	}
	public void setConvenienceFee(Long convenienceFee) {
		this.convenienceFee = convenienceFee;
	}
	
	
}
