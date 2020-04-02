package com.gft.apicasashow.resorces;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gft.apicasashow.domain.Evento;
import com.gft.apicasashow.domain.Venda;
import com.gft.apicasashow.services.VendaServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Vendas")
@RestController
@RequestMapping("/Vendas")
public class VendaResorces {

	@Autowired
	private VendaServices services;

	// GET
	@ApiOperation("Listar as vendas")
	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Venda>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(services.listar());
	}

	// GET (ID)
	@ApiOperation("Listar vendas por ID")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> GET(@ApiParam("ID da venda") @PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(services.buscar(id));
	}

	@ApiOperation("Criar venda")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(
			@ApiParam(name = "corpo", value = "Criação de um nova venda") @Valid @RequestBody Venda venda) {
		services.salvar(venda);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}