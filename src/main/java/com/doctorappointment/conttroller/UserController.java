package com.doctorappointment.conttroller;

import java.util.List;

import com.doctorappointment.dao.UserDao;
import com.doctorappointment.model.User;

public class UserController {
	UserDao userdao = new UserDao();

	public boolean createProduct(User user) {
		return userdao.createUser(user);
	}

	public User getUser(String userName) {
		return userdao.getUser(userName);
	}

	public List<User> getAllUsers() {
		return userdao.getAllUsers();
	}

	public void deleteUser(User user) {
		userdao.deleteUser(user);
	}

	public void editUser(User user) {
		userdao.editUser(user);
	}
}
