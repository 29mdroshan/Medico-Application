package com.hm.appointment.authservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class LoginCredentials {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int crId;
	@Column(name="username")
	private String username;
	private String password;
	@Enumerated
	private Role role;
	
}
