package com.doctorappointment.menuconttroller;
import java.util.Scanner;
import java.util.logging.Logger;

import com.doctorappointment.conttroller.AppointmentController;
import com.doctorappointment.conttroller.DoctorController;
import com.doctorappointment.exception.InvalidCredentailsException;
import com.doctorappointment.service.UserService;
import com.doctorappointment.validations.Verify;

public class MainMenu 
{
	private static final Logger logger;
	 static {
		 System.setProperty("java.util.logging.SimpleFormatter.format", "%5$s %n");
		 logger = Logger.getLogger(UserService.class.getName());
		 }
	 
	Scanner scanner = new Scanner(System.in);
	DoctorController adminController = new DoctorController();
	AppointmentController userController = new AppointmentController();
	Verify verify = new Verify();
	UserService userservice = new UserService();
	ChoiceCheck choiceCheck = new ChoiceCheck();
	
	public void menu()
	{
		int choice = 0;
		while(choice != 3)
		{
			logger.info("1.Admin");
			logger.info("2.User");
			logger.info("3.Exit");
			logger.info("Enter Your Choice.");
			choice = choiceCheck.checkChoice();
			switch(choice)
			{
				case 1:
					try
					{
						verify.adminCheck();
					}
					catch(InvalidCredentailsException e)
					{
						logger.info(e.getMessage());
					}
					break;
				case 2:
					mainMenu();
					break;
				case 3:
					System.exit(0);
					break;
				default:
					logger.info("Enter Correct Choice..");
			}
		}
	}
	
	
	
	
	public void mainMenu()
	{
		int choice = 0;
		while(choice != 3)
		{
			logger.info("1.Login");
			logger.info("2.SignUp");
			logger.info("3.Exit");
			logger.info("Enter Your Choice");
			choice = choiceCheck.checkChoice();
			switch(choice)
			{
				case 1:
					if(!verify.userCheck())
					{
						menu();
					}
					break;
				case 2:
					userservice.createUser();
					break;
				case 3:
					menu();
					break;
				default:
					logger.info("Enter Correct Choice..");
			}
			
		}
	}
	
}
