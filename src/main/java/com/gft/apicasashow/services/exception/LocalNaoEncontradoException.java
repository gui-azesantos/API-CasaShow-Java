package com.gft.apicasashow.services.exception;

public class LocalNaoEncontradoException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4205868810227809287L;

	public LocalNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public LocalNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
