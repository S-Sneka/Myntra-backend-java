package com.myntra.addData.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CategoryProductMapping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private Long ChildCategoryId;
	@Column
	private Long ProductId;
	
	public Long getChildCategoryId() {
		return ChildCategoryId;
	}
	public void setChildCategoryId(Long childCategoryId) {
		ChildCategoryId = childCategoryId;
	}
	public Long getProductId() {
		return ProductId;
	}
	public void setProductId(Long productId) {
		ProductId = productId;
	}
}
