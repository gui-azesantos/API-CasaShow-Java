package com.gft.apicasashow.services.exception;

public class UsuarioExistenteException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7920550587935233459L;

	public UsuarioExistenteException(String mensagem) {
		super(mensagem);
	}

	public UsuarioExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
