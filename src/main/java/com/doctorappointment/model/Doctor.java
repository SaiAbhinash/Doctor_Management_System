package com.doctorappointment.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id=202303;
	private String name;
	private int age;
	private String specialization;
	private int patientCheckingCountLimit;
	private int currentPatientCount;
	@OneToMany(mappedBy="doctor")
	private List<Appointment> appointments = new ArrayList<>();
	
	public Doctor() {}

	public Doctor(String name, int age, String specialization, int patientCheckingCountLimit,
			int currentPatientCount, List<Appointment> appointments) {
		this.name = name;
		this.age = age;
		this.specialization = specialization;
		this.patientCheckingCountLimit = patientCheckingCountLimit;
		this.currentPatientCount = currentPatientCount;
		this.appointments = appointments;
	}
	
	public Doctor(String name, int age, String specialization, int patientCheckingCountLimit,
			int currentPatientCount) {
		this.name = name;
		this.age = age;
		this.specialization = specialization;
		this.patientCheckingCountLimit = patientCheckingCountLimit;
		this.currentPatientCount = currentPatientCount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public int getPatientCheckingCountLimit() {
		return patientCheckingCountLimit;
	}

	public void setPatientCheckingCountLimit(int patientCheckingCountLimit) {
		this.patientCheckingCountLimit = patientCheckingCountLimit;
	}

	public int getCurrentPatientCount() {
		return currentPatientCount;
	}

	public void setCurrentPatientCount(int currentPatientCount) {
		this.currentPatientCount = currentPatientCount;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", age=" + age + ", specialization=" + specialization
				+ ", patientCheckingCountLimit=" + patientCheckingCountLimit + ", currentPatientCount="
				+ currentPatientCount + "]";
	}	
	
	public String print()
	{
		return "Doctor [ id="+id+", name="+name+" ]";
	}
	
}
