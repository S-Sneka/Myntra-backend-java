package com.myntra.product.dto;

import org.springframework.stereotype.Component;

import com.myntra.product.dao.ProductDao;

@Component
public class ProductsDtoM {
	private ProductDao product;
	private String imageUrl;
	public ProductDao getProduct() {
		return product;
	}
	public void setProduct(ProductDao product) {
		this.product = product;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	@Override
	public String toString() {
		return "ProductsDtoM [product=" + product.toString() + ", imageUrl=" + imageUrl + "]";
	}
	
}
