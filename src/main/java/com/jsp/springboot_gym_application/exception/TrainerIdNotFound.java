package com.jsp.springboot_gym_application.exception;

public class TrainerIdNotFound extends RuntimeException{

	private String message;

	public TrainerIdNotFound(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
