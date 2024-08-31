package com.doctorappointment.validations;

import java.util.Scanner;
import java.util.logging.Logger;
import com.doctorappointment.dao.UserDao;
import com.doctorappointment.exception.InvalidCredentailsException;
import com.doctorappointment.menuconttroller.AdminMenu;
import com.doctorappointment.menuconttroller.UserMenu;
import com.doctorappointment.model.User;
import com.doctorappointment.service.UserService;


public class Verify {
	private static final Logger logger;
	static {
		 System.setProperty("java.util.logging.SimpleFormatter.format", "%5$s %n");
		 logger = Logger.getLogger(Verify.class.getName());
		 }
	
	Scanner scanner=new Scanner(System.in);
	UserDao userdao=new UserDao();
	UserService userservice = new UserService();
	UserMenu usermenu = new UserMenu();
	AdminMenu adminmenu = new AdminMenu();
	

	
	
	public void adminCheck()
	 {
		 logger.info("Enter The UserName");
		 String username = scanner.next();
		 logger.info("Enter The Pasword");
		 String credentials = scanner.next();
		 if(username.equals("admin") && credentials.equals("admin"))
		 {
			 adminmenu.adminMenu();
		 }
		 else
		 {
			 throw new InvalidCredentailsException();
		 }
	 }
	
	 
	public boolean userCheck()
	{
		logger.info("Enter User Name:");
		String userName = scanner.next();
		User user = userdao.getUser(userName);
		boolean flag =true;
		if(user == null)
		{
			logger.info("User Not Found!");
			logger.info("Do You Want To Create New User (y/n)");
			String choice = scanner.next();
			if(choice.equalsIgnoreCase("y"))
			{
				userservice.createUser();
				logger.info("user added successfully");
			}
			else
			{
				flag=false;
			}		
		}	
		else
		{
			String userPassword = user.getPassword();
			logger.info("Enter Password:");
			String password = scanner.next();
			if(password.equals(userPassword))
			{
				usermenu.userMenu(user);
			}
			else
			{
				logger.info("Incorrect Credentails!");
				flag=false;
			}
		}
		return flag;
	}
}
