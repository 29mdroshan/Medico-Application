package com.hm.appointment.authservice.dto;

import com.hm.appointment.authservice.model.LoginCredentials;
import com.hm.appointment.authservice.model.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtToken {
//	private LoginCredentials logincr;
	private String username;
	private Role role;
	private String value;
}
