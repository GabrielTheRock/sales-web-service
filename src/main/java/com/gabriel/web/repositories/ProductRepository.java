package com.gabriel.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.web.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
