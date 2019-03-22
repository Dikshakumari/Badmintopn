package com.user.model.persistance;

import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlRootElement;
@Produces("application/json")
@XmlRootElement(name = "users")
public class Users {

	private int userId;
	private String username;
	private String userPassword;
	private String userEmailId;

	public Users() {
	}

	public Users(int userId, String username, String userPassword,
			String userEmailId) {
		this.userId = userId;
		this.username = username;
		this.userPassword = userPassword;
		this.userEmailId = userEmailId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Users [userId=").append(userId).append(", username=")
				.append(username).append(", userPassword=")
				.append(userPassword).append(", userEmailId=")
				.append(userEmailId).append("]");
		return builder.toString();
	}

}
