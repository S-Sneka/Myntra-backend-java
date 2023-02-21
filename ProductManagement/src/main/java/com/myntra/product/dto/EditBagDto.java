package com.myntra.product.dto;

public class EditBagDto {
	private Long productId;
	private String size;
	private String newSize;
	private Long quantity;
	private Boolean selected;
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getNewSize() {
		return newSize;
	}
	public void setNewSize(String newSize) {
		this.newSize = newSize;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Boolean getSelected() {
		return selected;
	}
	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
}
