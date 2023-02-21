package com.myntra.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myntra.order.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
}
