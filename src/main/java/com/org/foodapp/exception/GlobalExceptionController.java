package com.org.foodapp.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionController {
	@ExceptionHandler(CustomerIdNotFoundException.class)
	public ResponseEntity<?> CustomerIdNotFoundException(CustomerIdNotFoundException exception, HttpServletRequest request){
		ApiError apiError = new ApiError();
		apiError.setMessage(exception.getMessage());
		apiError.setLocalDateTime(LocalDateTime.now());
		apiError.setEndpointString(request.getRequestURI());
		apiError.setHttpStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(apiError, apiError.getHttpStatus());
	}
}
