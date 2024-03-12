package com.jsp.springboot_gym_application.exception;

public class AddressIdNotFound extends RuntimeException{

	private String message;

	public AddressIdNotFound(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
