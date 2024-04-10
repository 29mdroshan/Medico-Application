package com.hm.appointment.authservice.service;

import com.hm.appointment.authservice.model.LoginCredentials;

public interface LoginCredentialsService {

	public LoginCredentials getUserByUsername(String username);
	
	public LoginCredentials saveCredentials(LoginCredentials user);
	
	
	
}
