package com.myntra.product.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.myntra.product.exception.ExpiredJwtException;

@ControllerAdvice
public class ExceptionHandling {
	@ExceptionHandler(ExpiredJwtException.class)
	public ResponseEntity<APIResponse> handleExpiredJwtException(ExpiredJwtException e) {
		APIResponse apiresponse = new APIResponse();
		apiresponse.setMessage(e.getMessage());
		apiresponse.setData(null);
		apiresponse.setStatus(false);
		return ResponseEntity.status(HttpStatus.OK.value()).body(apiresponse);
	}
	
	@ExceptionHandler
	public ResponseEntity<APIResponse> handleException(Exception e) {
		e.printStackTrace();
		APIResponse apiresponse = new APIResponse();
		apiresponse.setMessage(e.getMessage());
		apiresponse.setStatus(false);
		return ResponseEntity.status(HttpStatus.OK.value()).body(apiresponse);

	}
}
