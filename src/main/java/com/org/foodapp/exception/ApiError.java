package com.org.foodapp.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ApiError {
	private String message;
	private LocalDateTime localDateTime;
	private String endpointString;
	private HttpStatus httpStatus;
}
