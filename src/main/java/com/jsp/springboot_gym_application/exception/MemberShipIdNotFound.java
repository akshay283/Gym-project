package com.jsp.springboot_gym_application.exception;

public class MemberShipIdNotFound extends RuntimeException{

	private String message;

	public MemberShipIdNotFound(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
