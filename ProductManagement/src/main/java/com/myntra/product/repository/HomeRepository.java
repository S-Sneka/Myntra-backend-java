package com.myntra.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myntra.product.entity.HomePage;


public interface HomeRepository extends JpaRepository<HomePage, Long>{

}
