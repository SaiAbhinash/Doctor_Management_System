package com.doctorappointment.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import com.doctorappointment.model.Appointment;
import com.doctorappointment.model.Doctor;

public class DoctorDAO {

	public void addDoctor(Doctor doctor) {
		Session session = BaseDao.getSession();
		session.beginTransaction();
		session.save(doctor);
		session.getTransaction().commit();
		session.close();
	}

	public void updateDoctor(Doctor doctor) {
		Session session = BaseDao.getSession();
		session.beginTransaction();
		session.update(doctor);
		session.getTransaction().commit();
		session.close();
	}

	public void deleteDoctor(Doctor doctor) {
		Session session = BaseDao.getSession();
		session.beginTransaction();
		session.delete(doctor);
		session.getTransaction().commit();
		session.close();
	}

	public List<Doctor> getAllDoctors() {
		Session session = BaseDao.getSession();
		session.beginTransaction();
		List<Doctor> doctors;
		Query<Doctor> q = session.createQuery("from Doctor", Doctor.class);
		doctors = q.list();
		session.close();
		return doctors;
	}

	public Doctor getDoctor(int id) {
		Session session = BaseDao.getSession();
		session.beginTransaction();
		Doctor doctor = session.get(Doctor.class, id);
		session.close();
		return doctor;
	}

	public List<Doctor> getDoctorsBySpecalization(String specialization) {
		Session session = BaseDao.getSession();
		session.beginTransaction();
		List<Doctor> doctors;
		Query<Doctor> q = session.createQuery("from Doctor where specialization = :specialization", Doctor.class);
		q.setParameter("specialization", specialization);
		doctors = q.list();
		session.close();
		return doctors;
	}

	
	public void incrementCurrentPatientCountForDoctor(int doctorId) {
		Session session = BaseDao.getSession();
		session.beginTransaction();
		String hql = "UPDATE Doctor d SET d.currentPatientCount = d.currentPatientCount + 1 WHERE d.id = :doctorId";
		session.createQuery(hql).setParameter("doctorId", doctorId).executeUpdate();
		session.close();
	}

	
	public void decrementCurrentPatientCountForDoctor(int doctorId) {
		Session session = BaseDao.getSession();
		session.beginTransaction();
		String hql = "UPDATE Doctor d SET d.currentPatientCount = d.currentPatientCount - 1 WHERE d.id = :doctorId";
		session.createQuery(hql).setParameter("doctorId", doctorId).executeUpdate();
		session.close();
	}

	public List<Appointment> getAllAppointments() {
		Session session = BaseDao.getSession();
		session.beginTransaction();
		List<Appointment> appointments;
		Query<Appointment> q = session.createQuery("from Appointment", Appointment.class);
		appointments = q.list();
		session.close();
		return appointments;
	}

	public List<Appointment> getAllAppointmentsbyUser(String userName) {
		Session session = BaseDao.getSession();
		session.beginTransaction();
		List<Appointment> appointments;
		Query<Appointment> q = session.createQuery("from Appointment where UserName = :userName", Appointment.class);
		q.setParameter(userName, userName);
		appointments = q.list();
		session.close();
		return appointments;
	}
}
