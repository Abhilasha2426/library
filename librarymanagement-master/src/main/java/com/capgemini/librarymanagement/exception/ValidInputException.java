package com.capgemini.librarymanagement.exception;

public class ValidInputException extends RuntimeException {
	String message;
	public ValidInputException(){
		this.message="Enter Valid Input";
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
