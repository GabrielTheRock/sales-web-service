package com.gabriel.web.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gabriel.web.entities.User;
import com.gabriel.web.services.UserService;

/*
 * Resource --> Service --> Repository
 * A aplicação funciona em camadas, começando pela resource
 * RequestMapping indica o endpoint para chamar o recurso
 */

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	/*
	 * O ResponseEntity é o retorno da requisição
	 * O ok corresponde ao código HTTP de sucesso (200)
	 * Body é o corpo da resposta, no caso um objeto
	 * Dentro desses métodos, chamamos métodos da classe de serviço, que acessa repository
	 */
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	/*
	 * No GetMapping, adiciona-se value para aceitar parâmetros no endpoint
	 * @PathVariable sinaliza que a variável é capturada pelo endpoint
	 */
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	/*
	 * @PostMapping indica que esse método é um post [inserção]
	 * @RequestBody indica que o objeto User será passado no corpo da requisição
	 * O URI serve para definir o caminho do novo recurso adicionado (é obrigatório passá-lo com o código 201)
	 */
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	/*
	 * O delete não retorna nada no corpo da resposta
	 * Por isso, o código da resposta é 204 (no content)
	 */
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
