package com.doctorappointment.service;

import java.util.List;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.doctorappointment.conttroller.DoctorController;
import com.doctorappointment.menuconttroller.ChoiceCheck;
import com.doctorappointment.model.Doctor;

public class DoctorService {
	DoctorController doctorController;
	ChoiceCheck choicecheck = new ChoiceCheck();

	public DoctorService() {
		this.doctorController = new DoctorController();
	}

	private static final Logger logger = LoggerFactory.getLogger(DoctorService.class);

	Scanner scanner = new Scanner(System.in);

	public void addDoctor()
	{
		logger.info("Enter Doctor Name: ");
		String name = scanner.next();
		logger.info("Enter Doctor Age: ");
		int age = scanner.nextInt();
		scanner.nextLine();
		logger.info("Enter Doctor Specialization: ");
		String specialization = scanner.nextLine();
		logger.info("Enter Doctor Patient Checking Count Limit: ");
		int patientCheckingCountLimit = Integer.parseInt(scanner.nextLine());
		int currentpatientcount = 0;
		Doctor doctor = new Doctor(name, age, specialization, patientCheckingCountLimit, currentpatientcount);
		doctorController.addDoctor(doctor);
		logger.info("Doctor added successfully!");
	}
	
	public void upadatedoctor()
	{
		logger.info("Enter DoctorId To Be Updated");
		int doctorId = scanner.nextInt();
		Doctor doctor = doctorController.getDoctor(doctorId);
		if(doctor != null)
		{
			updateDoctor(doctor);
		}
		else
		{
			logger.info("Doctor Not Found!");
		}
	}
	
	public void updateDoctor(Doctor doctor)
	{
		logger.info("Enter Upadted Doctor Name: ");
		String name = scanner.next();
		doctor.setName(name);
		logger.info("Enter Upadted Doctor Age: ");
		int age = scanner.nextInt();
		scanner.nextLine();
		doctor.setAge(age);
		logger.info("Enter Updated Doctor Specialization: ");
		String specialization = scanner.nextLine();
		doctor.setSpecialization(specialization);
		logger.info("Enter Doctor Patient Checking Count Limit: ");
		int patientCheckingCountLimit = Integer.parseInt(scanner.nextLine());
		doctor.setPatientCheckingCountLimit(patientCheckingCountLimit);
		doctorController.updateDoctor(doctor);
		logger.info("Doctor Updated Successfully!");
	}
	
	public void viewAllDoctors()
	{
		List<Doctor> doctors = doctorController.getAllDoctors();
		for(Doctor doctor:doctors)
		{
			logger.info("{} {} {} {}",doctor.getId(),doctor.getName(),doctor.getPatientCheckingCountLimit(),doctor.getCurrentPatientCount());
		}
	}
	
	public void viewDoctorsBySpecialization()
	{
		logger.info("Enter Specialization");
		String specialization = scanner.next();
		List<Doctor> doctors = doctorController.getDoctorsBySpecalization(specialization);
		for(Doctor doctor:doctors)
		{
			logger.info("{} {}",doctor.getId(),doctor.getName());
		}
	}
	
	
}
