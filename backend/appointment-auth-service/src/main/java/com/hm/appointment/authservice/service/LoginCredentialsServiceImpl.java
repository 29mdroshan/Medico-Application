package com.hm.appointment.authservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hm.appointment.authservice.model.LoginCredentials;

import com.hm.appointment.authservice.repository.LoginCredentialsRepository;


@Service
public class LoginCredentialsServiceImpl implements LoginCredentialsService {
	@Autowired
	private LoginCredentialsRepository repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public LoginCredentials getUserByUsername(String username) {
		return repo.findUserByUsername(username);
	}
	
	@Override
	public LoginCredentials saveCredentials(LoginCredentials user) {
		String password = user.getPassword();
		String encodedPassword = passwordEncoder.encode(password);
		user.setPassword(encodedPassword);
		return repo.save(user);
	}

	
	
}
