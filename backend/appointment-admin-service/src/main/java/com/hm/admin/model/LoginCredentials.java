package com.hm.admin.model;

import javax.persistence.Enumerated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginCredentials {

	private String username;
	private String password;
	@Enumerated
	private Role role;
	
}
