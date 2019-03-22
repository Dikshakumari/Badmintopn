package com.iris.webservice.web.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iris.webservice.model.persistance.User;
import com.iris.webservice.model.service.UserService;

@RestController
public class UserController {

	private UserService userService;
	private static final Logger LOGGER = Logger.getLogger(UserController.class
			.getName());

	public UserController() {
	}

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<User> users() {
		List<User> usersList = userService.getAllUsers();
		return usersList;
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public User getUserById(@PathVariable Integer userId) {
		if (userId == null) {
			LOGGER.log(Level.INFO, "UserId is null");
		}
		return userService.getUserById(userId);

	}

	@RequestMapping(value = "/users/auth/{userEmailId}/{userPassword}", method = RequestMethod.GET, headers = "Accept=application/json")
	public User getUserDetails(@PathVariable String userEmailId,
			@PathVariable String userPassword) {
		if (userEmailId == null) {
			LOGGER.log(Level.INFO, "User EmailId is null");
		}
		return userService.findUserByUserEmailId(userEmailId, userPassword);
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST, headers = "Accept=application/json")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public User updateUser(@PathVariable Integer userId, @RequestBody User user) {
		return userService.updateUser(user);
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void removeUser(@PathVariable Integer userId) {
		userService.removeUser(userId);
	}
}