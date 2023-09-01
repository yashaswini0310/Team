package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.entity.ErrorResponse;

public class TeamExceptionHandler {
	
	@ExceptionHandler(TeamNotFoundException.class)

	public ResponseEntity<ErrorResponse> handleException(TeamNotFoundException exception) {

	ErrorResponse error = new ErrorResponse();
	error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
	error.setMessage(exception.getMessage()); // get message from exception
	error.setTimeStamp(LocalDateTime.now()); // system time
	return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); // 404 Not found

	}
}
