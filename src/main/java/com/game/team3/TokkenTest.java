package com.game.team3;

import java.security.Key;
import java.util.Date;

import javax.security.auth.Subject;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class TokkenTest {
	private static final Long EXPIRE_TIME = 2000L;
	public static void main(String[]args) {
		Date date = new Date();
		Date exprieDate = new Date(date.getTime() + EXPIRE_TIME);
		String keyStr = "12345678901345678901324567890123456789012";
		Key key = Keys.hmacShaKeyFor(keyStr.getBytes());
		String token = Jwts.builder()
			.setHeaderParam("typ", "JWT")
			.setSubject("id")
			.setIssuedAt(date)
			.setExpiration(exprieDate)
			.signWith(key, SignatureAlgorithm.HS256)
			.compact();
		
		log.info("token => {}", token);
		
		
		String subject = Jwts.parserBuilder()
		.setSigningKey(key)
		.build()
		.parseClaimsJws(token)
		.getBody()
		.getSubject();
		System.out.println(subject);
	}
}
