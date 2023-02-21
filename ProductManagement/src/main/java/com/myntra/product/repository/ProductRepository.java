package com.myntra.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myntra.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
