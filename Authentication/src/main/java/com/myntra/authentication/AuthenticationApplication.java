package com.myntra.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
	}
	@SuppressWarnings("removal")
	@Bean
	public Long Long() {
		return new Long(0);
	}
	@Bean
	public String String() {
		return new String("");
	}
}