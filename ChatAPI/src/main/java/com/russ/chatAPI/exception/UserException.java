package com.russ.chatAPI.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class UserException {
	private final String message;
	private final HttpStatus httpstatus;
	private final ZonedDateTime timestamp;
	
	public UserException(String message, HttpStatus httpstatus, ZonedDateTime timestamp) {
		super();
		this.message = message;
		this.httpstatus = httpstatus;
		this.timestamp = timestamp;
	}

	
	

}
