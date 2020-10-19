package com.gabriel.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.web.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
	
}
