package com.gabriel.web.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.web.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	//método que retorna todos os usuários
	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "gabriel", "gabriel@gmail", "11123456789", "gabriel123");
		return ResponseEntity.ok().body(u);
	}
}
