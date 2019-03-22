package com.iris.webservice.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iris.webservice.model.persistance.User;
import com.iris.webservice.model.persistance.UserDao;

@Service
@Transactional
public class UserServiceImplementation implements UserService {

	private UserDao userDao;

	public UserServiceImplementation() {
	}

	@Autowired
	public UserServiceImplementation(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public User getUserById(Integer userId) {
		return userDao.getUserById(userId);
	}

	@Override
	public User addUser(User user) {
		return userDao.add(user);
	}

	@Override
	public User updateUser(User user) {
		return userDao.update(user);
	}

	@Override
	public User removeUser(Integer userId) {
		return userDao.remove(userId);
	}

	@Override
	public User findUserByUserEmailId(String userEmailId, String userPassword) {
		return userDao.getUserByUserEmailId(userEmailId, userPassword);
	}
}