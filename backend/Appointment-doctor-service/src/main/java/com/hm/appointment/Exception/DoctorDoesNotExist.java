package com.hm.appointment.Exception;

public class DoctorDoesNotExist extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DoctorDoesNotExist(String message) {
		super(message);
	}
	
	

}
