package com.myntra.product.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.myntra.product.dao.WishListDao;

@Component
public class WishViewDto {
	private List<WishListDao> items;
	private Long countOfItems;
	public List<WishListDao> getItems() {
		return items;
	}
	public void setItems(List<WishListDao> items) {
		this.items = items;
	}
	public Long getCountOfItems() {
		return countOfItems;
	}
	public void setCountOfItems(Long countOfItems) {
		this.countOfItems = countOfItems;
	}
	
}
