package com.advlatam.test.advance;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class UsuarioController {
	private UsuarioRepository repository;

	public UsuarioController(UsuarioRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/lista-usuarios")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Usuario> usuarios() {
		return repository.findAll().stream().collect(Collectors.toList());
	}
}
