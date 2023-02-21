package com.myntra.product.dao;

import org.springframework.stereotype.Component;

@Component
public class ProductDao {
	
	private Long id;
	private String name;
	private String brand;
	private Long ratings;
	private Float star;
	private Long mrp;
	private Integer discount;
	private boolean isWishListed;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Long getRatings() {
		return ratings;
	}
	public void setRatings(Long ratings) {
		this.ratings = ratings;
	}
	public Float getStar() {
		return star;
	}
	public void setStar(Float star) {
		this.star = star;
	}
	public Long getMrp() {
		return mrp;
	}
	public void setMrp(Long mrp) {
		this.mrp = mrp;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public boolean isWishListed() {
		return isWishListed;
	}
	public void setWishListed(boolean isWishListed) {
		this.isWishListed = isWishListed;
	}
}
