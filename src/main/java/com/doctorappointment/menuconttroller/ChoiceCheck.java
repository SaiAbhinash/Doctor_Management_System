package com.doctorappointment.menuconttroller;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

import com.doctorappointment.service.UserService;

public class ChoiceCheck 
{
	private static final Logger logger;
	 static {
		 System.setProperty("java.util.logging.SimpleFormatter.format", "%5$s %n");
		 logger = Logger.getLogger(UserService.class.getName());
		 }
	
	Scanner scanner = new Scanner(System.in);
	public int checkChoice()
	{
		try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
        	logger.info("Invalid input. Please enter a valid integer!");
        	scanner.nextLine();
        	return 0;
        }
	}
}
