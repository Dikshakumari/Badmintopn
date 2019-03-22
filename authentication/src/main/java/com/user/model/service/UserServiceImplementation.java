package com.user.model.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.user.model.persistance.UserDaoImplementationUsingJdbc;
import com.user.model.persistance.Users;

@Path("/users")
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public class UserServiceImplementation implements UserService {

	UserDaoImplementationUsingJdbc userDao = new UserDaoImplementationUsingJdbc();

	@Override
	@GET
	public List<Users> getAllUsers() {
		List<Users> list = userDao.getAllUsers();
		return list;
	}

	@Override
	@GET
	@Path("/{userId}")
	public Users getUserById(@PathParam("userId") Integer userId) {
		return userDao.getUserById(userId);
	}

	@Override
	@GET
	@Path("/searchedName/{username}")
	public Users getUserByUsername(@PathParam("username") String username) {
		return userDao.getUserByUsername(username);
	}

	@Override
	@GET
	@Path("/authenticate/{userEmailId}/{userPassword}")
	public Users getUserByUserEmailId(
			@PathParam("userEmailId") String userEmailId,
			@PathParam("userPassword") String userPassword) {
		return userDao.findUserByUserEmailId(userEmailId, userPassword);
	}

	@Override
	@POST
	public Users addUser(Users users) {
		return userDao.addUser(users);
	}

	@Override
	@PUT
	@Path("/{userId}")
	public Users updateUser(@PathParam("userId") Integer userId, Users users) {
		return userDao.updateUser(users);
	}

	@Override
	@DELETE
	@Path("/{userId}")
	public Users deleteUser(@PathParam("userId") Integer userId) {
		return userDao.deleteUser(userId);
	}
	
	

}
