package com.example.app.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.model.Usuario;
import com.example.app.model.UsuarioRepository;
import com.example.app.service.UsuarioService;

/**
 * Implementação da <b>Strategy</b> {@link UsuarioService}, que foi injetada
 * pelo Spring (via {@link Autowired}). Dessa forma, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 * 
 * @author Filipe Miranda
 */
@Service
public class UsuarioServiceImplementation implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Iterable<Usuario> buscarUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario buscarUsuario(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.get();
	}

	@Override
	public void inserirUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);

	}

	@Override
	public void alterarUsuario(Long id, Usuario usuario) {
		Optional<Usuario> usuarioBd = usuarioRepository.findById(id);
		if (usuarioBd.isPresent()) {
			usuarioRepository.save(usuario);
		}

	}

	@Override
	public void excluirUsuario(Long id) {
		usuarioRepository.deleteById(id);

	}

}
