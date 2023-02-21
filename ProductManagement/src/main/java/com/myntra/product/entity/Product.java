package com.myntra.product.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="Product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	@Column
	private String brand;
	@Column
	private String description;
	@Column
	private Long ratings;
	@Column
	private Float star;
	@Column
	private Long mrp;
	@Column
	private Integer discount;
	@Column
	private String color;
	@Column
	private String seller;
	@Column
	private String pincode;
	@Column
	private String offer;
	@Column
	private String emiOption;
	@Column
	private String productDetails;
	@Column
	private String sizeFit;
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}

	public String getEmiOption() {
		return emiOption;
	}

	public void setEmiOption(String emiOption) {
		this.emiOption = emiOption;
	}

	public String getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}

	public String getSizeFit() {
		return sizeFit;
	}

	public void setSizeFit(String sizeFit) {
		this.sizeFit = sizeFit;
	}

}