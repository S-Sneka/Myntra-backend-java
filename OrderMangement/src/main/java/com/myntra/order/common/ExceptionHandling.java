package com.myntra.order.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionHandling {	
	@ExceptionHandler
	public ResponseEntity<APIResponse> handleException(Exception e) {
		APIResponse apiresponse = new APIResponse();
		e.printStackTrace();
		apiresponse.setData(null);
		apiresponse.setMessage(e.getMessage());
		apiresponse.setStatus(false);
		return ResponseEntity.status(HttpStatus.OK.value()).body(apiresponse);
	}
}
