package com.myntra.addData.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myntra.addData.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
