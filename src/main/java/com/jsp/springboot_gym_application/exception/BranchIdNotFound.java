package com.jsp.springboot_gym_application.exception;

public class BranchIdNotFound extends RuntimeException{

	private String message;
	
	public BranchIdNotFound(String message)
	{
		super();
		this.message=message;
	}

	public String getMessage() {
		return message;
	}
	
}
