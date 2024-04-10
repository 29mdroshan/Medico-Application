package com.hm.appointment.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hm.appointment.authservice.model.LoginCredentials;


public interface LoginCredentialsRepository extends JpaRepository<LoginCredentials, Integer>{

	public LoginCredentials findUserByUsername(String username);
	
}
