package com.gft.apicasashow.services.exception;

public class EventoExistenteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1431228699893548585L;

	public EventoExistenteException(String mensagem) {
		super(mensagem);
	}

	public EventoExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
