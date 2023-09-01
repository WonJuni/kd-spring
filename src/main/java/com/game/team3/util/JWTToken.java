package com.game.team3.util;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.game.team3.vo.UserInfoVO;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
public class JWTToken {
	@org.springframework.beans.factory.annotation.Value("${jwt.token.key}")
	private final String JWT_TOKKEN_KEY;
	private final Long JWT_TOKEN_EXPIRE;
	
	public JWTToken(@org.springframework.beans.factory.annotation.Value("${jwt.token.key}")String jwtTokenkey,
			@org.springframework.beans.factory.annotation.Value("${jwt.token.expire}")long jwtTokenExpire) {
		this.JWT_TOKKEN_KEY = jwtTokenkey;
		JWT_TOKEN_EXPIRE = jwtTokenExpire;
	}
	

	public long getJwtExpire() {
		return JWT_TOKEN_EXPIRE;
	}
	
	
	
	public String getJwtTokenKey() {
		return JWT_TOKKEN_KEY;
	}
	
	public String getToken(String uiId) {
		Date date = new Date();
		UserInfoVO userInfoVO = new UserInfoVO();
		long expireDate = date.getTime() + JWT_TOKEN_EXPIRE;
		
		Key key = Keys.hmacShaKeyFor(JWT_TOKKEN_KEY.getBytes());
		log.info("key=>{}",key);
		String token = Jwts.builder()
		.setHeaderParam(Header.TYPE, Header.JWT_TYPE)
		.setSubject(uiId)
		.setIssuedAt(date)
		.setExpiration(new Date(expireDate))
		.claim("user", userInfoVO)
		.signWith(key,SignatureAlgorithm.HS256)
		.compact();
		
		return token;
	}
	
	public UserInfoVO getUserIdFromToken(String token) {
		Key key = Keys.hmacShaKeyFor(JWT_TOKKEN_KEY.getBytes());
		try {
			
			String userId = Jwts.parserBuilder()
			.setSigningKey(key)
			.build()
			.parseClaimsJws(token)
			.getBody()
			.getSubject();
			log.info("obj=>{}", userId);
		}catch (ExpiredJwtException eje) {
			log.error("expired");
		}catch(SignatureException se) {
			log.error("invalid signautre");
		}
		return null;
	}
}
