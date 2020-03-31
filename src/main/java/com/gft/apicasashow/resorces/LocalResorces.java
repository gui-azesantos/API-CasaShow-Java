package com.gft.apicasashow.resorces;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	private LocalServices localservices;

	// GET
	@ApiOperation("Listar os locais")
	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Local>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(localservices.listar());
	}
	
	//LISTAR LOCAL POR NOME CRESCENTE	
	@ApiOperation("Lista os locais por ordem crescente.")
	@RequestMapping(
			value="/asc", method = RequestMethod.GET)
	public ResponseEntity<List<Local>> listarasc() {
		List<Local> local = localservices.listarasc();
		return ResponseEntity.status(HttpStatus.OK).body(local);		
	}
	
	//LISTAR LOCAL POR NOME DECRESCENTE
	@ApiOperation("Lista os locais por ordem decrescente.")
	@RequestMapping(value="/desc",
			method = RequestMethod.GET)
	public ResponseEntity<List<Local>> listardesc() {
		List<Local> local = localservices.listardesc();
		return ResponseEntity.status(HttpStatus.OK).body(local);
	}
	
	//BUSCAR POR NOME
	@ApiOperation("Buscar local por nome.")
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Local>> buscarPorNome(@ApiParam(value="Nome do Local", example="Vila Mix") @PathVariable("nome")String nome){
		return ResponseEntity.status(HttpStatus.OK).body((localservices.buscarPorNome(nome)));
		
	}

	// POST
	@ApiOperation("Criar local")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@ApiParam(name = "corpo", value="Criação de um novo local")@Valid @RequestBody Local local) {
		localservices.salvar(local);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	// GET (ID)
	@ApiOperation("Listar autor por ID")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> GET(@ApiParam("ID do autor") @PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(localservices.buscar(id));
	}

	// DELETE
	@ApiOperation("Deletar local")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@ApiParam("ID do autor") @PathVariable("id") Long id) {
		this.localservices.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	// PUT
	@ApiOperation("Atualizar local")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@ApiParam(name = "corpo", value="Atualização de um local")@Valid @RequestBody Local local, @PathVariable("id") Long id) {
		local.setId(id);
		localservices.update(local);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}

