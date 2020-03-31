package com.gft.apicasashow.resorces;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	private EventoServices eventoservice;

	// GET
	@ApiOperation("Lista eventos")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Evento>> listar() {

		CacheControl cachecontrol = CacheControl.maxAge(20, TimeUnit.SECONDS);

		return ResponseEntity.status(HttpStatus.OK).cacheControl(cachecontrol).body(eventoservice.listar());
	}

	// POST
	@ApiOperation("Criar evento")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(
			@ApiParam(name = "corpo", value = "Criação de um novo evento") @Valid @RequestBody Evento evento) {
		eventoservice.salvar(evento);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	// GET (ID)
	@ApiOperation("Lista eventos por ID")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> GET(@ApiParam("ID do evento") @PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(eventoservice.buscar(id));
	}

	// DELETE
	@ApiOperation("Deletar evento")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@ApiParam("ID do evento") @PathVariable("id") Long id) {
		this.eventoservice.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	// PUT
	@ApiOperation("Atualizar evento")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(
			@ApiParam(name = "corpo", value = "Atualização de um evento") @Valid @RequestBody Evento evento,
			@PathVariable("id") Long id) {
		evento.setId(id);
		eventoservice.update(evento);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
