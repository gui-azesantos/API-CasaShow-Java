package com.gft.apicasashow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gft.apicasashow.domain.Venda;
import com.gft.apicasashow.repository.VendasRepository;
import com.gft.apicasashow.services.exception.VendaExistenteException;
import com.gft.apicasashow.services.exception.VendaNaoEncontradaException;

@Service
public class VendaServices {

	public VendasRepository repository;

	// LISTAR
	public List<Venda> listar() {
		return repository.findAll();
	}

	// SALVAR VENDA
	public Venda salvar(Venda venda) {
		if (venda.getId() != null) {
			Venda vendas = repository.findById(venda.getId()).orElse(null);
			if (vendas != null) {
				throw new VendaExistenteException("A Venda já existe.");
			}
		}
		return repository.save(venda);
	}

	// BUSCAR POR ID
	public Venda buscar(Long id) {
		Venda local = repository.findById(id).orElse(null);
		if (local == null) {
			throw new VendaNaoEncontradaException("A venda não pôde ser encontrado.");
		}
		return local;
	}
}
