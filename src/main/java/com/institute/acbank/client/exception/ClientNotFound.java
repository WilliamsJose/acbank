package com.institute.acbank.client.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ClientNotFound extends RuntimeException {

	private static final long serialVersionUID = 947880686669871398L;

	private HttpStatus status;

	public ClientNotFound(HttpStatus status, String message) {
		super(message);
		this.status = status;
	}

	public ClientNotFound(String message) {
		super(message);
	}

	public ClientNotFound(String message, Throwable error) {
		super(message, error);
	}

	public ClientNotFound(Throwable error) {
		super(error);
	}

}
