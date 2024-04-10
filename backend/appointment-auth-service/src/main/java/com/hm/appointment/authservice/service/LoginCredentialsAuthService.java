package com.hm.appointment.authservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hm.appointment.authservice.dto.JwtToken;
import com.hm.appointment.authservice.dto.UserCredentials;
import com.hm.appointment.authservice.exception.InvalidCredentialsException;
import com.hm.appointment.authservice.model.LoginCredentials;

import com.hm.appointment.authservice.repository.LoginCredentialsRepository;

import com.hm.appointment.authservice.util.JwtUtil;

@Service
public class LoginCredentialsAuthService {
	
	@Autowired
	private LoginCredentialsRepository repo;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public JwtToken validateCredentials(UserCredentials credentials) {
		
		LoginCredentials user = repo.findUserByUsername(credentials.getUsername());
		if(!passwordEncoder.matches(credentials.getPassword(),user.getPassword())) {
			throw new InvalidCredentialsException("Incorrect Password");
		}
		
		JwtToken jwt = jwtUtil.generateJwt(user.getUsername());
		

		
		return jwt;
		
		
	}
	
	
	
	
}
