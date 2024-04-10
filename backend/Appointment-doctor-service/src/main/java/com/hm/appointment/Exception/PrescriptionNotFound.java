package com.hm.appointment.Exception;

public class PrescriptionNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public PrescriptionNotFound(String message) {
		super(message);
	}
}
