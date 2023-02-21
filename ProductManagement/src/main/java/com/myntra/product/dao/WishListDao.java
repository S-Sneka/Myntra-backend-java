package com.myntra.product.dao;

import org.springframework.stereotype.Component;

import com.myntra.product.entity.Size;


@Component
public class WishListDao {
	private Long productId;
	private String brand;
	private String productName;
	private Long mrp;
	private Integer discount;
	private String image;
	private Long ratings;
	private Float star;
	private String seller;
	private Size size;
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
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
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	
}
