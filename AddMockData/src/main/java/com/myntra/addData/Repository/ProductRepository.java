package com.myntra.addData.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myntra.addData.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
