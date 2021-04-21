package com.institute.acbank.account.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AccountNotFound extends RuntimeException {

	private static final long serialVersionUID = -346758515522752636L;

	private HttpStatus status;

	public AccountNotFound(HttpStatus status, String message) {
		super(message);
		this.status = status;
	}

	public AccountNotFound(String message) {
		super(message);
	}

	public AccountNotFound(String message, Throwable error) {
		super(message, error);
	}

	public AccountNotFound(Throwable error) {
		super(error);
	}

}
