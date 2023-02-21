package com.myntra.order.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="order")
public class Order extends Auditable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	@Column
	private Long userId;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private List<Item> items;
	@Column
	private Long totalMrp;
	@Column
	private Long bagDiscount;
	@Column
	private Long couponDiscount;
	@Column
	private Long convenienceFee;
	@Column
	private Long total;
	@Column
	private String paymentMode;
	@Column
	private Long addressId;
	@Column
	private Boolean currentOrder;
	
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public Boolean getCurrentOrder() {
		return currentOrder;
	}
	public void setCurrentOrder(Boolean currentOrder) {
		this.currentOrder = currentOrder;
	}
	public Long getTotalMrp() {
		return totalMrp;
	}
	public void setTotalMrp(Long totalMrp) {
		this.totalMrp = totalMrp;
	}
	public Long getBagDiscount() {
		return bagDiscount;
	}
	public void setBagDiscount(Long bagDiscount) {
		this.bagDiscount = bagDiscount;
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
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public List<Item> getItems() {
		return items;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", items=" + items + "]";
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
}
