package com.doctorappointment.exception;

public class InvalidCredentailsException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public InvalidCredentailsException()
	{
		super("The Credentails Entered Are Incorrect!");
	}

}
