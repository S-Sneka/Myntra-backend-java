package com.myntra.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myntra.product.entity.ProductImage;

public interface ImageRepository extends JpaRepository<ProductImage, Long>{
	
	@Query("SELECT i FROM ProductImage i where i.productId=:id")
	List<ProductImage> findByProductId(@Param(value = "id") Long id);

}
