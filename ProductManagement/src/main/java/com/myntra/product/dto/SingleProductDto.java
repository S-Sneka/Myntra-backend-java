package com.myntra.product.dto;

import java.util.List;

import org.springframework.stereotype.Component;
import com.myntra.product.entity.Product;
import com.myntra.product.entity.ProductSpecification;
import com.myntra.product.entity.Size;

@Component
public class SingleProductDto {
	private Product product;
	private Size size;
	private ProductSpecification specification;
	private Boolean isWishListed;
	private List<String> images;
	public Boolean getIsWishListed() {
		return isWishListed;
	}
	public void setIsWishListed(Boolean isWishListed) {
		this.isWishListed = isWishListed;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	public ProductSpecification getSpecification() {
		return specification;
	}
	public void setSpecification(ProductSpecification specification) {
		this.specification = specification;
	}
}
