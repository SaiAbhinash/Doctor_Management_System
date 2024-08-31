package com.doctorappointment.conttroller;

import java.util.List;
import com.doctorappointment.dao.AppointmentDAO;
import com.doctorappointment.model.Appointment;

public class AppointmentController {
	private AppointmentDAO appointmentDAO = new AppointmentDAO();

	public void addAppointment(Appointment appointment) {
		appointmentDAO.addAppointment(appointment);
	}

	public Appointment verifyAppointment(int id) {
		return appointmentDAO.getAppointment(id);
	}

	public List<Appointment> getAllAppointments() {
		return appointmentDAO.getAllAppointments();
	}

	public List<Appointment> getAppointmentsByDoctorId(int doctorId) {
		return appointmentDAO.getAppointmentsByDoctorId(doctorId);
	}
	
	public void updateAppointment(Appointment appointment) {
		appointmentDAO.updateAppointment(appointment);
	}

}