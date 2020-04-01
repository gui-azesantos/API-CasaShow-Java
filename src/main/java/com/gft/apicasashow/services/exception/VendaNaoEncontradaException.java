package com.gft.apicasashow.services.exception;

public class VendaNaoEncontradaException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9075221508055381916L;

	public VendaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}

	public VendaNaoEncontradaException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
