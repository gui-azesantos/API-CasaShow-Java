package com.gft.apicasashow.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gft.apicasashow.services.exception.LocalExistenteException;
import com.gft.apicasashow.services.exception.LocalNaoEncontradoException;

@ControllerAdvice
public class ResorcesExceptionHandler {

	@ExceptionHandler(LocalNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleLivroNaoEncontrado(LocalNaoEncontradoException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O livro não pôde ser encontrado");
		erro.setMensagemdesenvolvedor("http://erros.socialbooks.com/404");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(LocalExistenteException.class)
	public ResponseEntity<DetalhesErro> handleLivroNaoEncontrado(LocalExistenteException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(409l);
		erro.setTitulo("O livro já existe");
		erro.setMensagemdesenvolvedor("http://erros.socialbooks.com/404");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<DetalhesErro> handleLivroNaoEncontrado(DataIntegrityViolationException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("requisição inválida");
		erro.setMensagemdesenvolvedor("http://erros.socialbooks.com/404");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
}
