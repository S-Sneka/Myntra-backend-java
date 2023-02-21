package com.myntra.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myntra.product.entity.ChildCategory;

public interface ChildCatRepository extends JpaRepository<ChildCategory, Long>{
	
	@Query("SELECT c FROM ChildCategory c where c.subCategoryId=:id")
	List<ChildCategory> findBySubCategoryId(@Param(value = "id") Long id);
	
}
