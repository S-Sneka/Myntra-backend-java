package com.myntra.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myntra.product.entity.Category;


public interface CategoryRepository extends JpaRepository<Category, Long>{

//	@Query("SELECT u FROM CustomUser u where u.email=:em")
//	CustomUser findByEmail(@Param(value = "em") String email);

}
