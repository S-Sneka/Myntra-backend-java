package com.myntra.product.dto;

import org.springframework.stereotype.Component;

@Component
public class OrderedProductDetails {
	private String brand;
	private String name;
	private String image;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
