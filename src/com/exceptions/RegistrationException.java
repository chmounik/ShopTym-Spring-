package com.exceptions;

public class RegistrationException extends Exception {
	private static final long serialVersionUID = 1L ;
	
	@Override
	public String getMessage() {
		return "Some error occurred while registering user" ;
	}
	
}
