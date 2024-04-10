package com.hm.appointment.authservice.exception;

public class UnauthorizedUserException extends RuntimeException {
	
	public UnauthorizedUserException(String message) {
		super(message);
	}

}
