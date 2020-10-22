package com.gabriel.web.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	/*
	 * Passo o id do objeto que não foi encontrado na mensagem de exceção
	 */
	public ResourceNotFoundException(Object id) {
		super("Resource not found. Id " + id);
	}
}
