package com.hm.appointment.authservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hm.appointment.authservice.dto.JwtToken;
import com.hm.appointment.authservice.dto.UserCredentials;
import com.hm.appointment.authservice.model.LoginCredentials;
import com.hm.appointment.authservice.service.LoginCredentialsAuthService;
import com.hm.appointment.authservice.service.LoginCredentialsService;



@RestController
@RequestMapping("/authenticate")
//@CrossOrigin(origins= {"http://localhost:4200"})
public class LoginCredentialsAuthenticationController {
	
	@Autowired
	private LoginCredentialsService service;
	
	@Autowired
	private LoginCredentialsAuthService authService;
	

	@PostMapping("/user")
	public LoginCredentials addUser(@RequestBody LoginCredentials user) {
		return service.saveCredentials(user);
	}
	
	@PostMapping("/login")
	public JwtToken login(@RequestBody UserCredentials credentials) {
		return authService.validateCredentials(credentials);
	}
	
}
