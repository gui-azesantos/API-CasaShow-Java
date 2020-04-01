package com.gft.apicasashow.resorces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gft.apicasashow.domain.Usuario;
import com.gft.apicasashow.services.UsuarioServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Usuário")
@RestController
@RequestMapping("/Usuarios")
public class UsuarioResorces {
	@Autowired
	private UsuarioServices services;

	// LISTAR USUÁRIOS
	@ApiOperation("Listar os usuários")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(services.listar());
	}

	// LISTAR POR ID
	@ApiOperation("Listar os usuários pelo Id")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> GET(@ApiParam("ID do usuário") @PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(services.buscar(id));
	}

	// BUSCAR POR NOME
	@ApiOperation("Buscar local por nome.")
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Usuario>> buscarPorNome(
			@ApiParam(value = "Nome do Local", example = "teste@teste.com") @PathVariable("nome") String nome) {
		return ResponseEntity.status(HttpStatus.OK).body((services.buscarPorNome(nome)));

	}
}
