package com.user.model.service;

import java.util.List;


import com.user.model.persistance.Users;


public interface UserService {

	public List<Users> getAllUsers();

	public Users getUserById(Integer userId);

	public Users addUser(Users users);

	public Users updateUser(Integer userId, Users users);

	public Users deleteUser(Integer userId);

	public Users getUserByUsername(String username);
	
	public Users getUserByUserEmailId(String userEmailId, String userPassword);

}