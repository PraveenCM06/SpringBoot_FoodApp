package com.org.foodapp.response;

import java.util.Optional;

import org.springframework.http.HttpStatus;

import com.org.foodapp.dto.User;

import lombok.Data;

@Data
public class ResponseStructure<T>{
	private T data;
	private HttpStatus httpStatus;
	private String message;
}