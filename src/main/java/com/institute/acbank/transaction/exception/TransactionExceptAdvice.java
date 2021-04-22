package com.institute.acbank.transaction.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class TransactionExceptAdvice extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(TransactionExcept.class)
	public ResponseEntity<Object> transactionExceptAdvice(TransactionExcept transactionException, WebRequest wr) {
		return super.handleExceptionInternal(transactionException, transactionException.getMessage(), new HttpHeaders(), transactionException.getStatus(), wr);
	}
	
}
