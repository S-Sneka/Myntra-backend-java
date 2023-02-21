package com.myntra.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myntra.product.entity.HomeCategories;

public interface HomeCategoriesRepository extends JpaRepository<HomeCategories, Long>{
	
	@Query("SELECT h FROM HomeCategories h where h.homeCategoryId=:id")
	List<HomeCategories> findByHomeCategoryId(@Param(value = "id") Long id);

}
