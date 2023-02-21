package com.myntra.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myntra.order.entity.DeliveryAddress;


public interface AddressRepository extends JpaRepository<DeliveryAddress, Long>{
	@Query("SELECT a FROM DeliveryAddress a where a.orderId=:ord")
	List<DeliveryAddress> findByOrderId(@Param(value = "ord") long orderId);
}
