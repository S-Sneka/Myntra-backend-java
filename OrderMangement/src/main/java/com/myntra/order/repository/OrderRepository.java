package com.myntra.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.myntra.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
	@Query("SELECT o FROM Order o where o.userId=:id and currentOrder=true")
	Order findCurrentOrderByUserId(@Param(value = "id") Long userId);
	
	@Query("select orderId from Order order by orderId desc limit 1")
	Long findOrderId();
	
}
