package com.myntra.order.dto;

import org.springframework.stereotype.Component;

import com.myntra.order.Status;

@Component
public class OrderedProductDto {
	private Long itemId;
	private Object productDetails;
	private String size;
	private Status status;
	public Object getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(Object productDetails) {
		this.productDetails = productDetails;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}
