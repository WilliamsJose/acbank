package com.institute.acbank.account.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AccountExcept extends RuntimeException {

	private static final long serialVersionUID = -346758515522752636L;

	private HttpStatus status;

	public AccountExcept(HttpStatus status, String message) {
		super(message);
		this.status = status;
	}

	public AccountExcept(String message) {
		super(message);
	}

	public AccountExcept(String message, Throwable error) {
		super(message, error);
	}

	public AccountExcept(Throwable error) {
		super(error);
	}

}
