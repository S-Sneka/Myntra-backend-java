package com.myntra.order.dto;


import org.springframework.stereotype.Component;

import com.myntra.order.Status;

@Component
public class TrackOrder {
	private Object productDetails;
	private Status status;
	private String orderedAt;
	private String dispatchedAt;
	private String shippedAt;
	private String deliveredAt;
	public Object getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(Object productDetails) {
		this.productDetails = productDetails;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getOrderedAt() {
		return orderedAt;
	}
	public void setOrderedAt(String orderedAt) {
		this.orderedAt = orderedAt;
	}
	public String getDispatchedAt() {
		return dispatchedAt;
	}
	public void setDispatchedAt(String dispatchedAt) {
		this.dispatchedAt = dispatchedAt;
	}
	public String getShippedAt() {
		return shippedAt;
	}
	public void setShippedAt(String shippedAt) {
		this.shippedAt = shippedAt;
	}
	public String getDeliveredAt() {
		return deliveredAt;
	}
	public void setDeliveredAt(String deliveredAt) {
		this.deliveredAt = deliveredAt;
	}
}
