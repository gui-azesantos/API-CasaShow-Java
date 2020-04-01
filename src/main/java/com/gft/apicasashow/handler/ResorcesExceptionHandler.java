package com.gft.apicasashow.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gft.apicasashow.services.exception.EventoExistenteException;
import com.gft.apicasashow.services.exception.EventoNaoEncontradoException;
import com.gft.apicasashow.services.exception.LocalExistenteException;
import com.gft.apicasashow.services.exception.LocalNaoEncontradoException;
import com.gft.apicasashow.services.exception.UsuarioExistenteException;
import com.gft.apicasashow.services.exception.UsuarioNaoEncontradoException;
import com.gft.apicasashow.services.exception.VendaExistenteException;
import com.gft.apicasashow.services.exception.VendaNaoEncontradaException;

@ControllerAdvice
public class ResorcesExceptionHandler {

	@ExceptionHandler(LocalNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleLocalNaoEncontrado(LocalNaoEncontradoException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O Local não pôde ser encontrado");
		erro.setMensagemdesenvolvedor("http://erros.eventos.com/404");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(LocalExistenteException.class)
	public ResponseEntity<DetalhesErro> handleLocalNaoEncontrado(LocalExistenteException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(409l);
		erro.setTitulo("O Local já existe");
		erro.setMensagemdesenvolvedor("http://erros.eventos.com/404");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}

	@ExceptionHandler(EventoNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleEventoNaoEncontrado(EventoNaoEncontradoException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O Evento não pôde ser encontrado");
		erro.setMensagemdesenvolvedor("http://erros.eventos.com/404");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(EventoExistenteException.class)
	public ResponseEntity<DetalhesErro> handleEventoExistente(EventoExistenteException e, HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(409l);
		erro.setTitulo("O Evento já existe");
		erro.setMensagemdesenvolvedor("http://erros.eventos.com/404");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<DetalhesErro> handleLivroNaoEncontrado(DataIntegrityViolationException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("Requisição inválida");
		erro.setMensagemdesenvolvedor("http://erros.eventos.com/404");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}

	@ExceptionHandler(UsuarioNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleUsuarioNaoEncontrado(UsuarioNaoEncontradoException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O usuário não pôde ser encontrado");
		erro.setMensagemdesenvolvedor("http://erros.eventos.com/404");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(UsuarioExistenteException.class)
	public ResponseEntity<DetalhesErro> handleUsuarioExistente(UsuarioExistenteException e, HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(409l);
		erro.setTitulo("O usuário já existe");
		erro.setMensagemdesenvolvedor("http://erros.eventos.com/404");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	@ExceptionHandler(VendaNaoEncontradaException.class)
	public ResponseEntity<DetalhesErro> handleVendaNaoEncontrado(LocalNaoEncontradoException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O usuário não pôde ser encontrado");
		erro.setMensagemdesenvolvedor("http://erros.eventos.com/404");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(VendaExistenteException.class)
	public ResponseEntity<DetalhesErro> handleVendaExistente(LocalExistenteException e, HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(409l);
		erro.setTitulo("O usuário já existe");
		erro.setMensagemdesenvolvedor("http://erros.eventos.com/404");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}

	
}
