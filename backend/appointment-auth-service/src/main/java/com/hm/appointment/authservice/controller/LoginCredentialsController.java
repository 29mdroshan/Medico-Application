package com.hm.appointment.authservice.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hm.appointment.authservice.dto.Message;

@RestController
@RequestMapping("/auth")
public class LoginCredentialsController {
	
	
	@GetMapping("/public")
	public Message sayHelloWorld() {
		return new Message("Hello World");
	}

	@GetMapping("/user")
	public Message sayHelloUser() {
		return new Message("Hello User");
	}
	
	@GetMapping("/doctor")
	public Message sayHelloAdmin() {
		return new Message("Hello Doctor");
	}
	
}
