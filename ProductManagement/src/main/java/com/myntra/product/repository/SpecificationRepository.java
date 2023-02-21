package com.myntra.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myntra.product.entity.ProductSpecification;

public interface SpecificationRepository extends JpaRepository<ProductSpecification, Long>{

	@Query("SELECT i FROM ProductSpecification i where i.productId=:id")
	List<ProductSpecification> findByProductId(@Param(value = "id") Long id);
	
}
