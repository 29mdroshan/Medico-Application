package com.hm.patient.bookapp.exception;

public class AppointmentByIdNotFound  extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public AppointmentByIdNotFound(String message) {
		super(message);
	}

}
