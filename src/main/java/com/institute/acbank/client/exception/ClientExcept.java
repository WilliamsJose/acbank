package com.institute.acbank.client.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ClientExcept extends RuntimeException {

	private static final long serialVersionUID = 947880686669871398L;

	private HttpStatus status;

	public ClientExcept(HttpStatus status, String message) {
		super(message);
		this.status = status;
	}

	public ClientExcept(String message) {
		super(message);
	}

	public ClientExcept(String message, Throwable error) {
		super(message, error);
	}

	public ClientExcept(Throwable error) {
		super(error);
	}

}
