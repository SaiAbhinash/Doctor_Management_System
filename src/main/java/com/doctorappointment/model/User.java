package com.doctorappointment.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User 
{
	@Id
	private String userName;
	private String name;
	private String password;
	private int age;
	private String gender;
	private String contactNo;
	@OneToMany(mappedBy="user")
	private List<Appointment> appointments = new ArrayList<>();
	
	public User() {}

	public User(String userName, String name, String password, int age, String gender, String contactNo,
			List<Appointment> appointments) {
		this.userName = userName;
		this.name = name;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.contactNo = contactNo;
		this.appointments = appointments;
	}

	public User(String userName, String name, String password, int age, String gender, String contactNo) {
		this.userName = userName;
		this.name = name;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.contactNo = contactNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", name=" + name +  ", age=" + age + ", gender="
				+ gender + ", contactNo=" + contactNo + "]";
	}
	
}
