package com.myntra.product.dto;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.myntra.product.dao.ChildCategoryDao;

@Component
public class ShopByCategories {
	private String categoryName;
	private String image;
	private Map<String,List<ChildCategoryDao>> subCategory;
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Map<String, List<ChildCategoryDao>> getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(Map<String, List<ChildCategoryDao>> subCategory) {
		this.subCategory = subCategory;
	}
}
