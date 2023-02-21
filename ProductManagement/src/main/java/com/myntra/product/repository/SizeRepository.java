package com.myntra.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myntra.product.entity.Size;

public interface SizeRepository extends JpaRepository<Size, Long>{

	@Query("SELECT s FROM Size s where s.productId=:id")
	List<Size> findByProductId(@Param(value = "id") Long id);

}
