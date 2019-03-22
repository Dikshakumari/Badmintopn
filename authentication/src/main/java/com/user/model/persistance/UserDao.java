package com.user.model.persistance;

import java.util.List;


public interface UserDao {
	
	public List<Users> getAllUsers();

	public Users getUserById(Integer userId);

	public Users addUser(Users users);

	public Users updateUser(Users users);

	public Users deleteUser(Integer userId);
	
	public Users getUserByUsername(String username);
	
	public Users findUserByUserEmailId(String userEmailId, String userPassword);
	
}