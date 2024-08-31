package com.doctorappointment.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import com.doctorappointment.model.User;

public class UserDao {
	public boolean createUser(User user) {
		Session session = BaseDao.getSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	public User getUser(String userId) {
		Session session = BaseDao.getSession();
		session.beginTransaction();
		User user = session.get(User.class, userId);
		session.getTransaction().commit();
		session.close();
		return user;
	}

	public List<User> getAllUsers() {
		Session session = BaseDao.getSession();
		session.beginTransaction();
		List<User> users;
		Query<User> q = session.createQuery("from User", User.class);
		users = q.list();
		session.getTransaction().commit();
		session.close();
		return users;
	}

	public void deleteUser(User user) {
		Session session = BaseDao.getSession();
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
		session.close();
	}

	public void editUser(User user) {
		Session session = BaseDao.getSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();
	}

}
