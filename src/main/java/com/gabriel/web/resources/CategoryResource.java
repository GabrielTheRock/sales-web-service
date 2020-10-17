package com.gabriel.web.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.web.entities.Category;
import com.gabriel.web.services.CategoryService;

/*
 * Resource --> Service --> Repository
 * A aplicação funciona em camadas, começando pela resource
 */

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	/*
	 * O ResponseEntity é o retorno da requisição
	 * O ok corresponde ao código HTTP de sucesso (200)
	 * Body é o corpo da resposta, no caso um objeto
	 * Dentro desses métodos, chamamos métodos da classe de serviço, que acessa repository
	 */
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	/*
	 * No GetMapping, adiciona-se value para aceitar parâmetros no endpoint
	 * @PathVariable sinaliza que a variável é capturada pelo endpoint
	 */
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
