package com.doctorappointment.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BaseDao {
	
	private BaseDao() {}
	
	
	private static SessionFactory sessionFactory;

	static {
		Configuration configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}
}
