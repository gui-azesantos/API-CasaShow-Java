package com.gft.apicasashow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.apicasashow.domain.Venda;
import com.gft.apicasashow.repository.VendasRepository;
import com.gft.apicasashow.services.exception.VendaExistenteException;
import com.gft.apicasashow.services.exception.VendaNaoEncontradaException;

@Service
public class VendaServices {

	@Autowired
	public VendasRepository repository;

	// LISTAR
	public List<Venda> listar() {
		return repository.findAll();
	}

	// SALVAR
	public Venda salvar(Venda venda) {
		if (venda.getId() != null) {
			Venda vendas = repository.findById(venda.getId()).orElse(null);
			if (vendas != null) {
				throw new VendaExistenteException("O Venda já existe!");
			}
		}
		return repository.save(venda);
	}

	// BUSCAR POR ID
	public Venda buscar(Long id) {
		Venda venda = repository.findById(id).orElse(null);
		if (venda == null) {
			throw new VendaNaoEncontradaException("A venda não pôde ser encontrado.");
		}
		return venda;
	}
	
	// VERIFICAR EXISTENCIA
		public void isExisteVenda(Venda venda) {
			buscar(venda.getId());
		}
}
