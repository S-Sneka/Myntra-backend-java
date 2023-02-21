package com.myntra.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myntra.product.entity.CouponMapping;

public interface CouponMappingRepository extends JpaRepository<CouponMapping, Long>{
	
	@Query("SELECT c FROM CouponMapping c where c.userId=:id")
	List<CouponMapping> findByUserId(@Param(value = "id") Long id);
	
}
