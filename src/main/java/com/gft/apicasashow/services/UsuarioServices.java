package com.gft.apicasashow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gft.apicasashow.domain.Usuario;
import com.gft.apicasashow.repository.UsuarioRepository;
import com.gft.apicasashow.services.exception.UsuarioNaoEncontradoException;

@Service
public class UsuarioServices {

	@Autowired
	private UsuarioRepository repository;

	// LISTAR
	public List<Usuario> listar() {
		return repository.findAll();
	}

	// BUSCAR POR ID
	public Usuario buscar(Long id) {
		Usuario usuario = repository.findById(id).orElse(null);
		if (usuario == null) {
			throw new UsuarioNaoEncontradoException("O usuário não pôde ser encontrado.");
		}
		return usuario;
	}

	// BUSCAR POR NOME
	public List<Usuario> buscarPorNome(String email) {
		List<Usuario> usuario = repository.findByEmailContaining(email);
		if (usuario == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return usuario;
	}
	

}
