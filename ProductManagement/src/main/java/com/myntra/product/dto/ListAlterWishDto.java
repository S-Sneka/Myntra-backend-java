package com.myntra.product.dto;

import java.util.List;

public class ListAlterWishDto {
	private List<Long> productIds;
	public List<Long> getProductIds() {
		return productIds;
	}
	public void setProductIds(List<Long> productIds) {
		this.productIds = productIds;
	}
	
}
