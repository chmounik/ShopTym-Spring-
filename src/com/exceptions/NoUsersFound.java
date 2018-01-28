package com.exceptions;

public class NoUsersFound extends Exception {
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "No users found" ;
	}
}
