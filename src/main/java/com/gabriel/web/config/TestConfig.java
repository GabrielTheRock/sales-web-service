package com.gabriel.web.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gabriel.web.entities.User;
import com.gabriel.web.repositories.UserRepository;


/*
 * Classe de configuração para instanciar o banco de dados
 * O CommandLineRunner serve para fazer com que essa classe rode ao executar o projeto
 */

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "João Pereira", "joao@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Fabiano Marinho", "fabiano@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
}
