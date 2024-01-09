package com.org.foodapp.exception;

public class CustomerIdNotFoundException extends RuntimeException {
	public CustomerIdNotFoundException(String message) {
		super(message);
	}
}
