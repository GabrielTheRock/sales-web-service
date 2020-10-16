package com.gabriel.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.web.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
	
}
