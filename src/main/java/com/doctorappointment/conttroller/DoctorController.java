package com.doctorappointment.conttroller;

import java.util.List;
import com.doctorappointment.dao.DoctorDAO;
import com.doctorappointment.model.Appointment;
import com.doctorappointment.model.Doctor;

public class DoctorController {
	private DoctorDAO doctorDAO;

	public DoctorController() {
		doctorDAO = new DoctorDAO();
	}

	public void addDoctor(Doctor doctor) {
		doctorDAO.addDoctor(doctor);
	}

	public Doctor getDoctor(int id) {
		return doctorDAO.getDoctor(id);
	}

	public void updateDoctor(Doctor doctor) {
		doctorDAO.updateDoctor(doctor);
	}

	public void deleteDoctor(Doctor doctor) {
		doctorDAO.deleteDoctor(doctor);
	}

	public List<Doctor> getAllDoctors() {
		return doctorDAO.getAllDoctors();
	}


	public List<Doctor> getAppointmentsBySpecalization(String specialization) {
		return doctorDAO.getDoctorsBySpecalization(specialization);
	}

	public void incrementCurrentPatientCountForDoctor(int doctorId) {
		doctorDAO.incrementCurrentPatientCountForDoctor(doctorId);
	}

	public void decrementCurrentPatientCountForDoctor(int doctorId) {
		doctorDAO.incrementCurrentPatientCountForDoctor(doctorId);
	}

	public List<Appointment> getAllAppointments() {
		return doctorDAO.getAllAppointments();
	}
	
	public List<Doctor> getDoctorsBySpecalization(String specialization)
	{
		return doctorDAO.getDoctorsBySpecalization(specialization);
	}

	public List<Appointment> getAllAppointmentsbyUser(String name) {
		return doctorDAO.getAllAppointmentsbyUser(name);
	}

}