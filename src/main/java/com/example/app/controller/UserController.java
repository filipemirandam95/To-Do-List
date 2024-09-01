package com.example.app.controller;

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

import com.example.app.model.Usuario;
import com.example.app.service.UsuarioService;

/**
 * Esse {@link RestController} representa nossa <b>Facade</b>, pois abstrai toda
 * a complexidade de integrações com o Banco de Dados H2 em uma interface
 * simples e coesa (API REST).
 * 
 * @author Filipe Miranda
 */
@RestController
@RequestMapping("usuarios")
public class UserController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping()
	public ResponseEntity<Iterable<Usuario>> buscarUsuarios() {
		return ResponseEntity.ok(usuarioService.buscarUsuarios());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarUsuario(@PathVariable Long id) {
		return ResponseEntity.ok(usuarioService.buscarUsuario(null));
	}

	@PostMapping
	public ResponseEntity<Usuario> inserirUsuario(@RequestBody Usuario usuario) {
		usuarioService.inserirUsuario(usuario);
		return ResponseEntity.ok(usuario);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Usuario> alterarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
		usuarioService.alterarUsuario(id, usuario);
		return ResponseEntity.ok(usuario);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirUsuario(@PathVariable Long id) {
		usuarioService.excluirUsuario(id);
		return ResponseEntity.ok().build();
	}
}
