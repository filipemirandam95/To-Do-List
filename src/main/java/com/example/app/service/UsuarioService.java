package com.example.app.service;

import com.example.app.model.Usuario;

public interface UsuarioService {
	
	Iterable<Usuario> buscarUsuarios();
	Usuario buscarUsuario(Long id);
	void inserirUsuario(Usuario usuario);
	void alterarUsuario(Long id,Usuario usuario);
	void excluirUsuario(Long id);

}
