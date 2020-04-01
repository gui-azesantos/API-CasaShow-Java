package com.gft.apicasashow.services.exception;

public class VendaExistenteException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3917931690857249089L;

	public VendaExistenteException(String mensagem) {
		super(mensagem);
	}

	public VendaExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
