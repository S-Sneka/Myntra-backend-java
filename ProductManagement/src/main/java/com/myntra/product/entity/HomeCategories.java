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
@Table(name="HomeCategories")
public class HomeCategories {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long imageId;
	
	@Column
	private String url;
	
	@Column
	private Long homeCategoryId;

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getHomeCategoryId() {
		return homeCategoryId;
	}

	public void setHomeCategoryId(Long homeCategoryId) {
		this.homeCategoryId = homeCategoryId;
	}

}
