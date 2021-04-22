package com.institute.acbank.account.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AccountExceptAdvice extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(AccountExcept.class)
	public ResponseEntity<Object> accountExceptAdvice(AccountExcept accountException, WebRequest wr) {
		return super.handleExceptionInternal(accountException, accountException.getMessage(), new HttpHeaders(), accountException.getStatus(), wr);
	}
	
}
