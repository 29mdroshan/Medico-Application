package com.hm.appointment.authservice.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hm.appointment.authservice.exception.InvalidCredentialsException;
import com.hm.appointment.authservice.exception.UnauthorizedUserException;
import com.hm.appointment.authservice.model.LoginCredentials;
import com.hm.appointment.authservice.model.Role;
import com.hm.appointment.authservice.service.LoginCredentialsService;


@Component
public class AuthFilter implements Filter {
	
	@Autowired
	private JwtUtil util;
	
	@Autowired
	private LoginCredentialsService service;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Filter Intercepted the Request");
		HttpServletRequest httpRequest=(HttpServletRequest) request;
		
		String uri = httpRequest.getRequestURI();
		
		if(uri.startsWith("/authenticate")) {
			System.out.println("Credentials filter");
			chain.doFilter(httpRequest, response);
			return;
		}
		
		
		String header = httpRequest.getHeader("auth");
		if(header==null || header.isEmpty()) {
			System.err.println("Token Not Present");
			throw new InvalidCredentialsException("Invalid Token/Credentials");
		}
		
		String username = util.decodeJwt(header);
		LoginCredentials user = service.getUserByUsername(username);
		System.out.println(user);
		if(user==null) {
			throw new InvalidCredentialsException("Invalid Token/Credentials");
		}
		
		if(uri.startsWith("/auth/user")){
			if(user.getRole()==Role.PATIENT) {
				System.out.println("Credentials filter");
					chain.doFilter(request, response);
					return;
			}
			else {
				throw new UnauthorizedUserException("Forbidden");
			}
		}
		
		else if(uri.startsWith("/auth/admin")){
			if(user.getRole()==Role.ADMIN) {
					chain.doFilter(request, response);
					return;
			}
			else {
				throw new UnauthorizedUserException("Forbidden");
			}
		}
		
		else if(uri.startsWith("/auth/doctor")){
			if(user.getRole()==Role.DOCTOR) {
					chain.doFilter(request, response);
					return;
			}
			else {
				throw new UnauthorizedUserException("Forbidden");
			}
		}
		
		
	
		
	}
	
}
