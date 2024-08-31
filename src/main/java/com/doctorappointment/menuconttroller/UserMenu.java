package com.doctorappointment.menuconttroller;

import java.util.Scanner;
import java.util.logging.Logger;

import com.doctorappointment.model.User;
import com.doctorappointment.service.AppointmentService;
import com.doctorappointment.service.DoctorService;
import com.doctorappointment.service.UserService;

public class UserMenu 
{
	
	private static final Logger logger;
	 static {
		 System.setProperty("java.util.logging.SimpleFormatter.format", "%5$s %n");
		 logger = Logger.getLogger(UserService.class.getName());
		 }
	 
	Scanner scanner = new Scanner(System.in);
	DoctorService doctorService = new DoctorService();
	AppointmentService appointmentService = new AppointmentService();
	ChoiceCheck choiceCheck = new ChoiceCheck();
	UserService userservice=new UserService();
	
	
	public void userMenu(User user)
	{	
		String action = "";
		while(!action.equals("q"))
		{
			logger.info("Enter action (book, view, delete, update, editdetails, editpassword or q to quit):");
			action = scanner.next();
			switch (action) {
			case "book":
				appointmentService.addAppointment(user);
				break;
			case "view":
				appointmentService.getAppointmentsByUserName(user.getUserName());
				break;
			case "delete":
				appointmentService.deleteAppointmnetByUser(user.getUserName());
				break;
			case "update":
				appointmentService.updateAppointmentByUser(user.getUserName());
				break;
			case "editdetails":
				userservice.editDetails(user);
				break;
			case "editpassword":
				userservice.editPassword(user);
				break;
			default:
				logger.info("Invalid action.");
				break;
			}

		}
	}
	

	

}
