package com.happy2code.demo.rest;

public class CoffeeNotFoundException extends RuntimeException{

	public CoffeeNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CoffeeNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CoffeeNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}
