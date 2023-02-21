package com.myntra.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myntra.product.entity.WishListProducts;

public interface WishListRepository extends JpaRepository<WishListProducts, Long>{
	
	@Query("SELECT p FROM WishListProducts p where p.productId=:prod and p.userId=:user")
	List<WishListProducts> findByProductUserId(@Param(value = "prod") Long prod,@Param(value = "user") Long user);
	
	@Query("SELECT p FROM WishListProducts p where p.userId=:user")
	List<WishListProducts> findByUserId(@Param(value = "user") Long user);
	
	@Query("SELECT p.productId FROM WishListProducts p where p.userId=:user")
	List<Long> findWishListedProducts(@Param(value = "user") Long user);
}
