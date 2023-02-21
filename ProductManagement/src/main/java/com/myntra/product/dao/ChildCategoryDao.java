package com.myntra.product.dao;

public class ChildCategoryDao {
	private Long childCategoryId;
	
	private String childCategoryName;
	
	public ChildCategoryDao(Long childCategoryId, String childCategoryName) {
		super();
		this.childCategoryId = childCategoryId;
		this.childCategoryName = childCategoryName;
	}
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
	
}
