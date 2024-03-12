package com.jsp.springboot_gym_application.exception;

public class BranchHeadIdNotFound extends RuntimeException {

	private String message;

	public BranchHeadIdNotFound(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
