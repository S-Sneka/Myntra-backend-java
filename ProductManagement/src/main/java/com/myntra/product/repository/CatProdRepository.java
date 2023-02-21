package com.myntra.product.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myntra.product.entity.CategoryProductMapping;

public interface CatProdRepository extends JpaRepository<CategoryProductMapping, Long>{

	
	@Query("SELECT cp FROM CategoryProductMapping cp where cp.ChildCategoryId=:id")
	List<CategoryProductMapping> findByCategoryId(@Param(value = "id") Long id);
}
