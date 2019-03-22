package com.tms.model.persistance;

import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlRootElement;

@Produces("application/json")
@XmlRootElement(name = "user")
public class User {

	private int userId;
	private String userName;
	private String userPassword;
	private String userEmailId;
	private String userRole;
	private boolean userActiveStatus;
	private User userManagerId;

	public User() {
	}

	public User(int userId, String userName, String userPassword,
			String userEmailId, String userRole, boolean userActiveStatus,
			User userManagerId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmailId = userEmailId;
		this.userRole = userRole;
		this.userActiveStatus = userActiveStatus;
		this.userManagerId = userManagerId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public boolean isUserActiveStatus() {
		return userActiveStatus;
	}

	public void setUserActiveStatus(boolean userActiveStatus) {
		this.userActiveStatus = userActiveStatus;
	}

	public User getUserManagerId() {
		return userManagerId;
	}

	public void setUserManagerId(User userManagerId) {
		this.userManagerId = userManagerId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userId=").append(userId).append(", userName=")
				.append(userName).append(", userPassword=")
				.append(userPassword).append(", userEmailId=")
				.append(userEmailId).append(", userRole=").append(userRole)
				.append(", userActiveStatus=").append(userActiveStatus)
				.append(", userManagerId=").append(userManagerId).append("]");
		return builder.toString();
	}
}