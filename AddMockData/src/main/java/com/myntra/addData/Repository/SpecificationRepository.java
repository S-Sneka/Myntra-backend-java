package com.myntra.addData.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myntra.addData.Entity.ProductSpecification;

public interface SpecificationRepository extends JpaRepository<ProductSpecification, Long>{

}
