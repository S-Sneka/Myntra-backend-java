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
@Table(name="ChildCategory")
public class ChildCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long childCategoryId;
	
	@Column
	private String childCategoryName;
	
	@Column
	private Long subCategoryId;
	
	public Long getChildCategoryId() {
		return childCategoryId;
	}
	public void setChildCategoryId(Long childCategoryId) {
		this.childCategoryId = childCategoryId;
	}
	public String getChildCategoryName() {
		return childCategoryName;
	}
	public void setChildCategoryName(String childCategoryName) {
		this.childCategoryName = childCategoryName;
	}
	public Long getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(Long subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	
	
}
