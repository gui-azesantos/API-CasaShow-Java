package com.gft.apicasashow.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gft.apicasashow.domain.Local;
import com.gft.apicasashow.repository.LocalRepository;
import com.gft.apicasashow.services.exception.EventoNaoEncontradoException;
import com.gft.apicasashow.services.exception.LocalExistenteException;
import com.gft.apicasashow.services.exception.LocalNaoEncontradoException;

@Service
public class LocalServices {

	@Autowired
	private LocalRepository repository;

	// LISTAR
	public List<Local> listar() {
		return repository.findAll();
	}

	// BUSCAR
	public Local buscar(Long id) {
		Local local = repository.findById(id).orElse(null);
		if (local == null) {
			throw new EventoNaoEncontradoException("O local não pôde ser encontrado.");
		}
		return local;
	}

	// SALVAR
	public Local salvar(Local local) {
		if (local.getId() != null) {
			Local locales = repository.findById(local.getId()).orElse(null);
			if (locales != null) {
				throw new LocalExistenteException("O local já existe!");
			}
		}
		return repository.save(local);
	}

	// DELETAR
	public void delete(Long id) {
		try {
			this.repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new LocalNaoEncontradoException("O Local não pôde ser encontrado");
		}
	}

	// ATUALIZAR
	public void update(Local local) {
		try {
			isExisteLocal(local);
			repository.save(local);
		} catch (EntityNotFoundException e) {
			throw new LocalNaoEncontradoException("O Local não pôde ser encontrado");
		}

	}

	// VERIFICAR EXISTENCIA
	public void isExisteLocal(Local local) {
		buscar(local.getId());
	}
}
