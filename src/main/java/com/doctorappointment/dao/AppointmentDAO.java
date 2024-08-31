package com.doctorappointment.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import com.doctorappointment.model.Appointment;

public class AppointmentDAO {

	public AppointmentDAO() {
		Session session = BaseDao.getSession();
		session.beginTransaction();
		session.createQuery("DELETE FROM Appointment WHERE DAY(appointmentDate) < DAY(current_date)").executeUpdate();
		session.getTransaction().commit();
		session.close();
	}

	public void addAppointment(Appointment appointment) {
		Session session = BaseDao.getSession();
		session.beginTransaction();
		session.save(appointment);
		session.getTransaction().commit();
		session.close();
	}

	public void deleteAppointment(Appointment appointment) {
		Session session = BaseDao.getSession();
		session.beginTransaction();
		session.delete(appointment);
		session.getTransaction().commit();
		session.close();
	}
	
	public Appointment getAppointment(int id) {
		Session session = BaseDao.getSession();
		session.beginTransaction();
		Appointment appointment = session.get(Appointment.class, id);
		session.close();
		return appointment;
	}

	public List<Appointment> getAllAppointments() {
		Session session = BaseDao.getSession();
		session.beginTransaction();
		List<Appointment> appointments = null;
		Query<Appointment> q = session.createQuery("from Appointment", Appointment.class);
		appointments = q.list();
		session.close();
		return appointments;
	}

	public List<Appointment> getAppointmentsByDoctorId(int doctorId) {
		Session session = BaseDao.getSession();
		session.beginTransaction();
		List<Appointment> appointments = null;
		Query<Appointment> q = session.createQuery("from Appointment where doctorId = :doctorId", Appointment.class);
		q.setParameter("doctorId", doctorId);
		appointments = q.list();
		session.close();
		return appointments;
	}
	
	public List<Appointment> getAppointmentsByUserName(String userName) {
		Session session = BaseDao.getSession();
		session.beginTransaction();
		List<Appointment> appointments = null;
		Query<Appointment> q = session.createQuery("from Appointment where user_userName = :userName", Appointment.class);
		q.setParameter("userName", userName);
		appointments = q.list();
		session.close();
		return appointments;
	}

	public void updateAppointment(Appointment appointment) {
		Session session = BaseDao.getSession();
		session.beginTransaction();
		session.update(appointment);
		session.getTransaction().commit();
		session.close();
	}

}
