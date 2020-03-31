package com.gft.apicasashow.resorces;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gft.apicasashow.domain.Evento;
import com.gft.apicasashow.services.EventoServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Eventos")
@RestController
@RequestMapping("/Eventos")
public class EventoResorces {
	@Autowired
	private EventoServices eventoservices;

	// GET
	@ApiOperation("Lista eventos")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Evento>> listar() {
		CacheControl cachecontrol = CacheControl.maxAge(20, TimeUnit.SECONDS);
		return ResponseEntity.status(HttpStatus.OK).cacheControl(cachecontrol).body(eventoservices.listar());
	}

	//LISTAR EVENTOS POR NOME CRESCENTE	
	@ApiOperation("Listar eventos em ordem crescente de nome.")
	@GetMapping("/nome/asc")
	public ResponseEntity<List<Evento>> ListarAsc() {
		return ResponseEntity.status(HttpStatus.OK).body(eventoservices.listarAsc());
	}
	
	//LISTAR EVENTOS POR NOME DECRESCENTE
	@ApiOperation("Listar eventos em ordem decrescente de nome.")
	@GetMapping("/nome/desc")
	public ResponseEntity<List<Evento>> ListarDesc() {
		return ResponseEntity.status(HttpStatus.OK).body(eventoservices.listarDesc());
	}

	// LISTAR EVENTOS POR CAPACIDADE CRESCENTE
	@ApiOperation("Listar eventos em ordem crescente de capacidade.")
	@GetMapping("/capacidade/asc")
	public ResponseEntity<List<Evento>> capacidadeAsc() {
		return ResponseEntity.status(HttpStatus.OK).body(eventoservices.capacidadeAsc());
	}

	// LISTA OS EVENTOS POR CAPACIDADE DECRESCENTE
	@ApiOperation("Listar eventos em ordem decrescente de capacidade.")
	@GetMapping("/capacidade/desc")
	public ResponseEntity<List<Evento>> capacidadeDesc() {
		return ResponseEntity.status(HttpStatus.OK).body(eventoservices.capacidadeDesc());
	}

	// LISTAR EVENTOS POR DATA CRESCENTE
	@ApiOperation("Listar eventos em ordem crescente de data.")
	@GetMapping("/data/asc")
	public ResponseEntity<List<Evento>> dataAsc() {
		return ResponseEntity.status(HttpStatus.OK).body(eventoservices.dataAsc());
	}

	// LISTAR EVENTOS POR DATA DECRESCENTE
	@ApiOperation("Listar eventos em ordem decrescente de data.")
	@GetMapping("/data/desc")
	public ResponseEntity<List<Evento>> dataDesc() {
		return ResponseEntity.status(HttpStatus.OK).body(eventoservices.dataDesc());
	}

	// LISTAR EVENTOS POR PREÇO CRESCENTE
	@ApiOperation("Listar eventos em ordem crescente de preço.")
	@GetMapping("/preco/asc")
	public ResponseEntity<List<Evento>> precoAsc() {
		return ResponseEntity.status(HttpStatus.OK).body(eventoservices.precoAsc());
	}

	// LISTAR EVENTOS POR PREÇO DECRESCENTE 
	@ApiOperation("Listar eventos em ordem decrescente de preço.")
	@GetMapping("/preco/desc")
	public ResponseEntity<List<Evento>> precoDesc() {
		return ResponseEntity.status(HttpStatus.OK).body(eventoservices.precoDesc());
	}

	// POST
	@ApiOperation("Criar evento")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(
			@ApiParam(name = "corpo", value = "Criação de um novo evento") @Valid @RequestBody Evento evento) {
		eventoservices.salvar(evento);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	// GET (ID)
	@ApiOperation("Lista eventos por ID")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> GET(@ApiParam("ID do evento") @PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(eventoservices.buscar(id));
	}

	// DELETE
	@ApiOperation("Deletar evento")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@ApiParam("ID do evento") @PathVariable("id") Long id) {
		this.eventoservices.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	// PUT
	@ApiOperation("Atualizar evento")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(
			@ApiParam(name = "corpo", value = "Atualização de um evento") @Valid @RequestBody Evento evento,
			@PathVariable("id") Long id) {
		evento.setId(id);
		eventoservices.update(evento);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
