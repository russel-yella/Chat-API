package com.russ.chatAPI.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CreateHandler {
	
	@ExceptionHandler(value = CreateUserException.class)
	public ResponseEntity<Object> handleUsedUserName(CreateUserException e){
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		UserException userException = new UserException(e.getMessage(),HttpStatus.BAD_REQUEST, ZonedDateTime.now());
		
		return new ResponseEntity<>(userException,badRequest);
	}
}
