package com.iris.webservice.model.service;

import java.util.List;

import com.iris.webservice.model.persistance.User;

public interface UserService {
	List<User> getAllUsers();

	User getUserById(Integer userId);

	User addUser(User user);

	User updateUser(User user);

	User removeUser(Integer userId);

	User findUserByUserEmailId(String userEmailId, String userPassword);
}