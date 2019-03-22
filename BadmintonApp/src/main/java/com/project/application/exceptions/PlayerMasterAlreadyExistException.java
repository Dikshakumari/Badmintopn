package com.project.application.exceptions;

public class PlayerMasterAlreadyExistException extends Exception {
	private static final long serialVersionUID = 1L;

	public PlayerMasterAlreadyExistException(String string) {
		super(string);
	}
}
