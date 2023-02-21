package com.myntra.product.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ListRemoveBagDto {
	private List<AlterBagDto> list;
	public List<AlterBagDto> getList() {
		return list;
	}
	public void setList(List<AlterBagDto> list) {
		this.list = list;
	}
}
