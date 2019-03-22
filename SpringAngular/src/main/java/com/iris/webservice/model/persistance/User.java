package com.iris.webservice.model.persistance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	@Column(nullable = false)
	private String userName;

	@Column(nullable = false, unique = true)
	private String userEmailId;

	@Column(nullable = false)
	private String userPassword;

	@Column(nullable = false)
	private String userRole;

	public User() {
	}

	public User(int userId, String userName, String userEmailId,
			String userPassword, String userRole) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmailId = userEmailId;
		this.userPassword = userPassword;
		this.userRole = userRole;
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

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userId=").append(userId).append(", userName=")
				.append(userName).append(", userEmailId=").append(userEmailId)
				.append(", userPassword=").append(userPassword)
				.append(", userRole=").append(userRole).append("]");
		return builder.toString();
	}

}