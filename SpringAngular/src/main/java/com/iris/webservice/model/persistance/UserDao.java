package com.iris.webservice.model.persistance;

import java.util.List;

public interface UserDao {

	public List<User> getAllUsers();

	public User getUserById(Integer userId);

	public User add(User user);

	public User update(User user);

	public User remove(Integer userId);

	public User getUserByUserEmailId(String userEmailId, String userPassword);

}