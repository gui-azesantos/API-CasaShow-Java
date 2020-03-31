package com.gft.apicasashow.services.exception;

public class EventoNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8939983600633951452L;

	public EventoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public EventoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
