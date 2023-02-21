package com.myntra.order.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CurrentOrders {
	private String placedOn;
	private Long orderNo;
	private Long total;
	private Object userDetails;
	private String paymentMode;
	private List<OrderedProductDto> itemsInThisOrder;
	public String getPlacedOn() {
		return placedOn;
	}
	public void setPlacedOn(String placedOn) {
		this.placedOn = placedOn;
	}
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public Object getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(Object userDetails) {
		this.userDetails = userDetails;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public List<OrderedProductDto> getItemsInThisOrder() {
		return itemsInThisOrder;
	}
	public void setItemsInThisOrder(List<OrderedProductDto> itemsInThisOrder) {
		this.itemsInThisOrder = itemsInThisOrder;
	}
}
