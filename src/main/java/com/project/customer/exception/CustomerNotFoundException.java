package com.project.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final String message;
	private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

	public CustomerNotFoundException(HttpStatus httpStatus, String message) {
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public CustomerNotFoundException(String message) {
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
