package com.myntra.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myntra.product.entity.SubCategory;

public interface SubCatRepository extends JpaRepository<SubCategory, Long>{

	@Query("SELECT c FROM SubCategory c where c.categoryId=:id")
	List<SubCategory> findByCategoryId(@Param(value = "id") Long id);

}
