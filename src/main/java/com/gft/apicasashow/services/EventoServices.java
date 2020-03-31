package com.gft.apicasashow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gft.apicasashow.domain.Evento;
import com.gft.apicasashow.repository.EventoRepository;
import com.gft.apicasashow.services.exception.EventoExistenteException;
import com.gft.apicasashow.services.exception.EventoNaoEncontradoException;
import com.gft.apicasashow.services.exception.LocalNaoEncontradoException;

@Service
public class EventoServices {


	@Autowired
	private EventoRepository repository;
	
	private LocalServices localsservice;

	// LISTAR
	public List<Evento> listar() {
		return repository.findAll();
	}

	// BUSCAR
	public Evento buscar(Long id) {
		Evento evento = repository.findById(id).orElse(null);
		if (evento == null) {
			throw new LocalNaoEncontradoException("O Evento não pôde ser encontrado.");
		}
		return evento;
	}

	// SALVAR
	public Evento salvar(Evento evento) {
		if (evento.getId() != null) {
			Evento eventos = repository.findById(evento.getId()).orElse(null);
			eventos.qtdIngresso = eventos.capacidade; 
			if (eventos != null) {
				throw new EventoExistenteException("O Evento já existe!");
			}
		}

		return repository.save(evento);
	}

	// DELETAR
	public void delete(Long id) {
		try {
			this.repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EventoNaoEncontradoException("O Evento não pode ser encontrado");
		}
	}

	// ATUALIZAR
	public void update(Evento evento) {
		isExisteEvento(evento);
		localsservice.isExisteLocal(evento.getLocal());
		repository.save(evento);

	}

	// VERIFICAR EXISTÊNCIADO EVENTO
	private void isExisteEvento(Evento evento) {
		buscar(evento.getId());
	}

	
}
