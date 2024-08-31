package com.doctorappointment.exception;

public class DoctorNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DoctorNotFoundException()
	{
		super("Doctor Not Found!");
	}

}
