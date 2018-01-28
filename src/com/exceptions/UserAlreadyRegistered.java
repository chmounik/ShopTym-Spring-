package com.exceptions;

public class UserAlreadyRegistered extends Exception {
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "User trying to register is already registered" ;
	}
}
