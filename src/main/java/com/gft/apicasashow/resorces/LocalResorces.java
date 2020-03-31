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

import com.gft.apicasashow.domain.Local;
import com.gft.apicasashow.services.LocalServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Locais")
@RestController
@RequestMapping("/Local")
public class LocalResorces {


	@Autowired
	private LocalServices autoresservice;

	// GET
	@ApiOperation("Lista os locais")
	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Local>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(autoresservice.listar());
	}

	// POST
	@ApiOperation("Criar local")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@ApiParam(name = "corpo", value="Criação de um novo local")@Valid @RequestBody Local local) {
		autoresservice.salvar(local);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	// GET (ID)
	@ApiOperation("Lista autor por ID")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> GET(@ApiParam("ID do autor") @PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(autoresservice.buscar(id));
	}

	// DELETE
	@ApiOperation("Deletar local")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@ApiParam("ID do autor") @PathVariable("id") Long id) {
		this.autoresservice.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	// PUT
	@ApiOperation("Atualizar local")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@ApiParam(name = "corpo", value="Atualização de um local")@Valid @RequestBody Local local, @PathVariable("id") Long id) {
		local.setId(id);
		autoresservice.update(local);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}

