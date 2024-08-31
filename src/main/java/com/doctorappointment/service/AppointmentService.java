package com.doctorappointment.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.doctorappointment.conttroller.AppointmentController;
import com.doctorappointment.conttroller.UserController;
import com.doctorappointment.dao.AppointmentDAO;
import com.doctorappointment.dao.DoctorDAO;
import com.doctorappointment.dao.UserDao;
import com.doctorappointment.model.Appointment;
import com.doctorappointment.model.Doctor;
import com.doctorappointment.model.User;

public class AppointmentService {

	private static final Logger logger = LoggerFactory.getLogger(AppointmentService.class);

	UserController userController = new UserController();
	AppointmentController appointmentController = new AppointmentController();
	DoctorDAO doctorDAO = new DoctorDAO();
	UserDao userDAO = new UserDao();
	AppointmentDAO appointmentDAO = new AppointmentDAO();
	Scanner scanner = new Scanner(System.in);

	public void addAppointment(User user) {
		logger.info("Enter specialization name which you want to check: ");
		String specializationName = scanner.nextLine();
		printDoctors(specializationName);
		logger.info("Enter Doctor Id:");
		int doctorId = scanner.nextInt();
		Doctor doctor = doctorDAO.getDoctor(doctorId);
		LocalDate appointmentDate = LocalDate.now();
		Appointment appointment = new Appointment(user, doctor, appointmentDate);
		appointmentDAO.addAppointment(appointment);
		logger.info("Appointment added successfully.");
		doctorDAO.incrementCurrentPatientCountForDoctor(doctorId);
	}

	public void addAppointmentByAdmin() {
		logger.info("Enter UserName");
		String userName = scanner.next();
		User user = userDAO.getUser(userName);
		if (user != null) {
			addAppointment(user);
		} else {
			logger.info("User Not Found!");
		}
	}

	public void getAppointmentsByUserName(String userName) {
		List<Appointment> appointments = appointmentDAO.getAppointmentsByUserName(userName);
		for (Appointment appointment : appointments) {
			printAppointment(appointment);
		}
	}

	public void viewAppointments() {
		List<Appointment> appointments = appointmentDAO.getAllAppointments();
		for (Appointment appointment : appointments) {
			
			printAppointment(appointment);
		}
	}

	public void printAppointment(Appointment appointment) {
		
		logger.info("-------------------------------");
		logger.info("Appointment ID: {}",appointment.getId());
		logger.info("Patient Name: {}",appointment.getUser().getName());
		logger.info("Patient Age: {}",appointment.getUser().getAge());
		logger.info("Patient ContactNo: {}",appointment.getUser().getContactNo());
		logger.info("Doctor ID: {}",appointment.getDoctor().getId());
		logger.info("Doctor Name: {}",appointment.getDoctor().getName());
		logger.info("Doctor Specialization: {}",appointment.getDoctor().getSpecialization());
		logger.info("Appointment Date: {}",appointment.getAppointmentDate());
		logger.info("-------------------------------");
	}
	public void deleteAppointmnetByUser(String userName) {
		logger.info("Enter AppointmentID to Delete");
		int appointmentId = scanner.nextInt();
		Appointment appointment = appointmentDAO.getAppointment(appointmentId);
		if (appointment.getUser().getUserName().equals(userName)) {
			appointmentDAO.deleteAppointment(appointment);
		} else
			logger.info("Appointment Not Found!");
	}

	public void updateAppointmentByUser(String userName) {
		logger.info("Enter AppointmentID to Update");
		int appointmentId = scanner.nextInt();
		Appointment appointment = appointmentDAO.getAppointment(appointmentId);
		if (appointment.getUser().getUserName().equals(userName)) {
			updateAppointment(appointment);
		} else {
			logger.info("Appointment Not Found");
		}
	}

	public void updateAppointment(Appointment appointment) {
		logger.info("Enter new specialization name which you want to check: ");
		String specializationName = scanner.nextLine();
		printDoctors(specializationName);
		int doctotid = appointment.getDoctor().getId();
		doctorDAO.decrementCurrentPatientCountForDoctor(doctotid);
		logger.info("Enter Doctor Id:");
		int doctorId = scanner.nextInt();
		Doctor doctor = doctorDAO.getDoctor(doctorId);
		appointment.setDoctor(doctor);
		appointmentDAO.updateAppointment(appointment);
		logger.info("Appointment Updated successfully.");
		doctorDAO.incrementCurrentPatientCountForDoctor(doctorId);
	}

	public void printDoctors(String specializationName) {
		List<Doctor> doctors = doctorDAO.getDoctorsBySpecalization(specializationName);
		for (Doctor doctor : doctors) {
			if (doctor.getCurrentPatientCount() != doctor.getPatientCheckingCountLimit())
				logger.info("{} {}",doctor.getId(),doctor.getName());
			else {
				logger.info("no doctors");
			}
		}
	}

}