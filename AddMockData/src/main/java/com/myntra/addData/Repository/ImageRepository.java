package com.myntra.addData.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myntra.addData.Entity.ProductImage;

public interface ImageRepository extends JpaRepository<ProductImage, Long>{

}
