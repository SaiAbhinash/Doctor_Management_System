package com.doctorappointment.exception;

public class PatientNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public PatientNotFoundException()
	{
		super("Patient Not Found!");
	}

}
