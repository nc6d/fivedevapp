package com.five.auth.util;

import com.five.auth.exception.JwtTokenMalformedException;
import com.five.auth.exception.JwtTokenMissingException;
import com.five.auth.model.authorities.Role;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtUtil {

	@Value("${jwt.secret}")
	private String jwtSecret;

	@Value("${jwt.token.validity}")
	private long tokenValidity;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@PostConstruct
	protected void init() {
		jwtSecret = Base64.getEncoder().encodeToString(jwtSecret.getBytes());
	}

	public String generateToken(String email, Role role) {

		Claims claims = Jwts.claims().setSubject(email);
		claims.put("role", role);

		long nowMillis = System.currentTimeMillis();
		long expMillis = nowMillis + tokenValidity;
		Date exp = new Date(expMillis);
		return Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(new Date(nowMillis))
				.setExpiration(exp)
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	}

}
