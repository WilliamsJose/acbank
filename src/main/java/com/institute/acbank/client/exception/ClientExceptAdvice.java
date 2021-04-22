package com.institute.acbank.client.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ClientExceptAdvice extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ClientExcept.class)
	public ResponseEntity<Object> clientExceptAdvice(ClientExcept clientException, WebRequest wr) {
		return super.handleExceptionInternal(clientException, clientException.getMessage(), new HttpHeaders(), clientException.getStatus(), wr);
	}
	
}
