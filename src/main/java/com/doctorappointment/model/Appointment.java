package com.doctorappointment.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@ManyToOne
	private User user;
	@ManyToOne
	private Doctor doctor;
	private LocalDate appointmentDate;
	
	public Appointment() {}

	public Appointment(User user, Doctor doctor, LocalDate appointmentDate) {
		this.user = user;
		this.doctor = doctor;
		this.appointmentDate = appointmentDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", user=" + user + ", doctor=" + doctor + ", appointmentDate="
				+ appointmentDate + "]";
	}
	
	
	
}
