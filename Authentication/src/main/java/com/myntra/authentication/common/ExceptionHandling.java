package com.myntra.authentication.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.myntra.authentication.exception.UserNotFoundException;

import io.jsonwebtoken.ExpiredJwtException;

@ControllerAdvice
public class ExceptionHandling {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<APIResponse> handleUserNotFoundException(UserNotFoundException e) {
		APIResponse apiresponse = new APIResponse();
		apiresponse.setMessage(e.getMessage());
		apiresponse.setData(null);
		apiresponse.setStatus(false);
		return ResponseEntity.status(HttpStatus.OK.value()).body(apiresponse);
	}

	@ExceptionHandler(ExpiredJwtException.class)
	public ResponseEntity<APIResponse> handleExpiredJwtException(ExpiredJwtException e) {
		APIResponse apiresponse = new APIResponse();
		apiresponse.setMessage("Token expired");
		apiresponse.setData(null);
		apiresponse.setStatus(false);
		return ResponseEntity.status(HttpStatus.OK.value()).body(apiresponse);
	}
	
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<APIResponse> handleCredentilsException(BadCredentialsException e) {
		APIResponse apiresponse = new APIResponse();
		apiresponse.setMessage(e.getMessage());
		apiresponse.setData(null);
		apiresponse.setStatus(false);
		return ResponseEntity.status(HttpStatus.OK.value()).body(apiresponse);
	}
	
	@ExceptionHandler
	public ResponseEntity<APIResponse> handleException(Exception e) {
		APIResponse apiresponse = new APIResponse();
		apiresponse.setData(null);
		apiresponse.setMessage(e.getMessage());
		apiresponse.setStatus(false);
		return ResponseEntity.status(HttpStatus.OK.value()).body(apiresponse);

	}
}
