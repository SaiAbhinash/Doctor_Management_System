package com.doctorappointment.menuconttroller;

import java.util.Scanner;
import java.util.logging.Logger;

import com.doctorappointment.service.AppointmentService;
import com.doctorappointment.service.DoctorService;
import com.doctorappointment.service.UserService;

public class AdminMenu 
{
	private static final Logger logger;
	Scanner scanner = new Scanner(System.in);
	DoctorService doctorService = new DoctorService();
	AppointmentService appointmentService = new AppointmentService();
	UserService userservice=new UserService();
	ChoiceCheck choiceCheck = new ChoiceCheck();
	
	
	
	 static {
		 System.setProperty("java.util.logging.SimpleFormatter.format", "%5$s %n");
		 logger = Logger.getLogger(UserService.class.getName());
		 }
		 
	
	public void adminMenu()
	{
		MainMenu mainmenu = new MainMenu();
		int action = 0;
		while(action  != 8)
		{
			logger.info("1.Add Doctor");
			logger.info("2.Add Appointment");
			logger.info("3.Update Doctor");
			logger.info("4.View All Doctors");
			logger.info("5.View All Appointments");
			logger.info("6.View All Users");
			logger.info("7.View Doctor's Name By Specalization");
			logger.info("8.Quit");
			action = choiceCheck.checkChoice();
			switch (action) {
			case 1:
				doctorService.addDoctor();
				break;
			case 2:
				appointmentService.addAppointmentByAdmin();
				break;
			case 3:
				doctorService.upadatedoctor();
				break;
			case 4:
				doctorService.viewAllDoctors();
				break;
			case 5:
				appointmentService.viewAppointments();
				break;
			case 6:
				userservice.viewAllUsers();
				break;
			case 7:
				doctorService.viewDoctorsBySpecialization();
				break;
			case 8:
				mainmenu.menu();
				break;
			default:
				logger.info("Invalid action.");
				break;
		
			}
		}
	}
	
}
