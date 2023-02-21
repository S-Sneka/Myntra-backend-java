package com.myntra.authentication.dto;

public class JwtToken {
	private  String jwt;
	
	public String getJwt() {
		return jwt;
	}
	public JwtToken() {
		super();
	}
	public JwtToken(String jwt) {
		super();
		this.jwt = jwt;
	}
}