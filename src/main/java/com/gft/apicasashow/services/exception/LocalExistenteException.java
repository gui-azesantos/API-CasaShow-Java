package com.gft.apicasashow.services.exception;

public class LocalExistenteException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 8021446183916298558L;

	public LocalExistenteException(String mensagem) {
		super(mensagem);
	}

	public LocalExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
