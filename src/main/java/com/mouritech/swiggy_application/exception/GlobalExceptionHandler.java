package com.mouritech.swiggy_application.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorDetails> handleException(ResourceNotFoundException ine) {
		ErrorDetails errorResponse = new ErrorDetails();
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(ine.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<ErrorDetails>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorDetails> handleException(Exception ex) {
		ErrorDetails errorResponse = new ErrorDetails();
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<ErrorDetails>(errorResponse, HttpStatus.BAD_REQUEST);

	}
}
