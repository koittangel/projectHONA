package com.koitt.hona.model;

public class PaymentException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public PaymentException(String msg) {
		super(msg);
	}
}
