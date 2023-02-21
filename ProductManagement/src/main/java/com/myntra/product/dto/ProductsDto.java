package com.myntra.product.dto;

import java.util.List;

import org.springframework.stereotype.Component;
import com.myntra.product.dao.ProductDao;
@Component
public class ProductsDto {
	private ProductDao product;
	private List<String> images;
	public ProductDao getProduct() {
		return product;
	}
	public void setProduct(ProductDao product) {
		this.product = product;
	}
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
}
