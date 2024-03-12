package com.jsp.springboot_gym_application.exception;

public class GymIdNotFound extends RuntimeException {

	private String message;
	public String getMessage() {
		return message;
	}
	public GymIdNotFound(String message)
	{
		super();
		this.message=message;
	}
}
