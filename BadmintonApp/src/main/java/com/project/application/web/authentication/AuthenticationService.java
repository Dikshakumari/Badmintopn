package com.project.application.web.authentication;

import java.io.IOException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.project.application.badminton.playermaster.PlayerMaster;
import com.project.application.badminton.playermaster.PlayerMasterServiceImplementation;
import com.project.application.exceptions.UnmatchingPlayerMasterCredentialsException;


public class AuthenticationService {
	Logger logger = Logger.getLogger(AuthenticationService.class.getName());

	public boolean authenticate(String authCredentials) throws UnmatchingPlayerMasterCredentialsException {

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
		final String playerMobileNumber = arrOfStr[0];
		final String playerPassword = arrOfStr[1];

		PlayerMasterServiceImplementation pmsi = new PlayerMasterServiceImplementation();
		PlayerMaster ifPlayerMasterExists = pmsi.isValidPlayerMaster(playerMobileNumber, playerPassword);

		if (null == ifPlayerMasterExists.getPlayerPassword())
			return false;

		return ifPlayerMasterExists.getPlayerMobileNumber().equals(playerMobileNumber)
				&& ifPlayerMasterExists.getPlayerPassword().equals(playerPassword);
	}
}