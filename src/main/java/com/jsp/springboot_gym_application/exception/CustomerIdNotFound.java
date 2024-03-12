package com.jsp.springboot_gym_application.exception;

public class CustomerIdNotFound extends RuntimeException {

	private String message;
	
	public CustomerIdNotFound(String message)
	{
		super();
		this.message=message;
	}

	public String getMessage() {
		return message;
	}
	
	
}
