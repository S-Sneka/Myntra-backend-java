package com.myntra.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myntra.product.entity.BagProducts;

public interface BagRepository extends JpaRepository<BagProducts,Long>{

	@Query("SELECT p FROM BagProducts p where p.productId=:prod and p.userId=:user")
	List<BagProducts> findByProductUserId(@Param(value = "prod") Long prod,@Param(value = "user") Long user);
	
	@Query("SELECT p FROM BagProducts p where p.userId=:user")
	List<BagProducts> findByUserId(@Param(value = "user") Long user);
	
	@Query("SELECT p FROM BagProducts p where p.productId=:prod and p.userId=:user and p.size=:siz")
	List<BagProducts> findByProductUsernSize(@Param(value = "prod") Long prod,@Param(value = "user") Long user,@Param(value = "siz") String size);
}
