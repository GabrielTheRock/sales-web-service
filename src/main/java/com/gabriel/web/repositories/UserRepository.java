package com.gabriel.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.web.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	
}
