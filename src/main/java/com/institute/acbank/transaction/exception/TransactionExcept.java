package com.institute.acbank.transaction.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TransactionExcept extends RuntimeException {

	private static final long serialVersionUID = 7016715777780639895L;
	
	private HttpStatus status;

	public TransactionExcept(HttpStatus status, String message) {
		super(message);
		this.status = status;
	}

	public TransactionExcept(String message) {
		super(message);
	}

	public TransactionExcept(String message, Throwable error) {
		super(message, error);
	}

	public TransactionExcept(Throwable error) {
		super(error);
	}

}
