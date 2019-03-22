package com.user.model.web.authentication;

import java.io.IOException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.user.model.persistance.Users;
import com.user.model.service.UserServiceImplementation;

public class AuthenticationService {
	Logger logger = Logger.getLogger(AuthenticationService.class.getName());

	public boolean authenticate(String authCredentials) {

		if (null == authCredentials)
			return false;
		final String encodedUserPassword = authCredentials.replaceFirst("Basic"
				+ " ", "");
		String usernameAndPassword = null;
		try {
			byte[] decodedBytes = Base64.getDecoder().decode(
					encodedUserPassword);
			usernameAndPassword = new String(decodedBytes, "UTF-8");
		} catch (IOException e) {
			logger.log(Level.INFO, "IOException", e);
		}
		String[] arrOfStr = usernameAndPassword.split(":");
		final String userEmail = arrOfStr[0];
		final String password = arrOfStr[1];

		UserServiceImplementation usi = new UserServiceImplementation();
		Users ifUserExists = usi.getUserByUserEmailId(userEmail, password);

		if (null == ifUserExists.getUsername())
			return false;

		return ifUserExists.getUserEmailId().equals(userEmail)
				&& ifUserExists.getUserPassword().equals(password);
	}
}