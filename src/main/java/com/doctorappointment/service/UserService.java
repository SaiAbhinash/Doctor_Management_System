package com.doctorappointment.service;


import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import com.doctorappointment.conttroller.UserController;
import com.doctorappointment.dao.UserDao;
import com.doctorappointment.model.User;

public class UserService
{
	private static final Logger logger;
	UserDao userdao = new UserDao();
	Scanner scanner = new Scanner(System.in);
	UserController usercontroller = new UserController();
	
	 static {
	 System.setProperty("java.util.logging.SimpleFormatter.format", "%5$s %n");
	 logger = Logger.getLogger(UserService.class.getName());
	 }
	 
	 

	public void createUser()
	{
		logger.info("Enter UserName");
		String username = scanner.next();
		logger.info("Enter Name");
		String name = scanner.next();
		logger.info("Enter Password");
		String password = scanner.next();
		logger.info("Enter Your Age:");
		int age = scanner.nextInt();
		logger.info("Enter Your Gender");
		String gender = scanner.next();
		logger.info("Enter Your Contact Number:");
		String contactNo = scanner.next();
		User user = new User(username,name,password,age,gender,contactNo);
		userdao.createUser(user);
	}
	
	
	
	public void viewAllUsers()
    {
        List<User> users = null;
		users = usercontroller.getAllUsers();		
		if(users != null) 
		{
		    for(User user : users) 
		    {
		    	logger.info(user.getUserName()+" "+user.getName());
		    }
		}
        else
    	{
    		logger.info("No Users to Display");
    	}
    }

	public void editPassword(User user)
	{
		logger.info("enter old password:");
		String oldpass=scanner.next();
		if(user.getPassword().equals(oldpass)) {
			logger.info("Enter the New Password:");
			String password = scanner.next();
			user.setPassword(password);
			usercontroller.editUser(user);
		}
		else {
			logger.info("sorry,yor are old password was dosen't match. \n Please try again");
		}
	}
	
	public void deleteUser(User user)
	{
		logger.info("Do You Want To Delete? (y/n)");
		String choice = scanner.next();
		if(choice.equalsIgnoreCase("y"))
		{
			usercontroller.deleteUser(user);
		}
	}
	
	public void editDetails(User user)
	{
		logger.info("Enter the New Name:");
		String name = scanner.next();
		user.setName(name);
		logger.info("enter updated Age");
		int age = scanner.nextInt();
		user.setAge(age);
		logger.info("Enter Updated ContactNo:");
		String contactno=scanner.next();
		user.setContactNo(contactno);
		usercontroller.editUser(user);
		
		
	}
	
}