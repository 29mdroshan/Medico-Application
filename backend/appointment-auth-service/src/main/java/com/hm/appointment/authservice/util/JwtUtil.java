package com.hm.appointment.authservice.util;

import java.security.Key;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.hm.appointment.authservice.dto.JwtRequest;
import com.hm.appointment.authservice.dto.JwtToken;
import com.hm.appointment.authservice.model.LoginCredentials;
import com.hm.appointment.authservice.repository.LoginCredentialsRepository;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil implements UserDetailsService {

	private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	@Autowired
	LoginCredentialsRepository repo;

	public JwtToken generateJwt(String username) {

		long currentMillis = System.currentTimeMillis();

		long expiryMillis = currentMillis + (60 * 30 * 1000);
		Date expiryDate = new Date(expiryMillis);
		String token = Jwts.builder()
				.signWith(key)
				.setSubject(username)
				.setExpiration(expiryDate)
				.compact();
		LoginCredentials user=repo.findUserByUsername(username);

		return new JwtToken(user.getUsername(),user.getRole(),token);

	}

	public String decodeJwt(String jwt) {

		if (jwt == null || jwt.isEmpty()) {
			return null;
		}
		jwt = jwt.trim();
		Jws<Claims> jws = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt);
		System.out.println(jws);
		Claims claims = jws.getBody();
		String username = claims.getSubject();
		return username;

	}

	private Set getAuthorities(LoginCredentials user) {

		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
		return authorities;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginCredentials user = repo.findUserByUsername(username);
		if (user != null) {
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					getAuthorities(user));
		} else {
			throw new UsernameNotFoundException("Username is not valid");
		}
	}



}
