package com.user.model.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.user.model.connection.ConnectionFactory;

public class UserDaoImplementationUsingJdbc implements UserDao {

	Logger logger = Logger.getLogger(UserDaoImplementationUsingJdbc.class
			.getName());

	private static final String USER_ID = "userId";
	private static final String USERNAME = "username";
	private static final String USER_PASSWORD = "userPassword";
	private static final String USER_EMAIL_ID = "userEmailId";

	private Connection connection;

	public UserDaoImplementationUsingJdbc() {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public List<Users> getAllUsers() {
		List<Users> userList = new ArrayList<>();

		try (Statement stmt = connection.createStatement();) {

			try (ResultSet resultSet = stmt.executeQuery("SELECT * from users");) {
				while (resultSet.next()) {
					Users users = new Users();
					users.setUserId(resultSet.getInt(USER_ID));
					users.setUsername(resultSet.getString(USERNAME));
					users.setUserPassword(resultSet.getString(USER_PASSWORD));
					users.setUserEmailId(resultSet.getString(USER_EMAIL_ID));

					userList.add(users);
				}
			}
		} catch (SQLException e) {
			logger.log(Level.INFO, "all", e);
		}
		logger.log(Level.INFO, "users data list: {0}", userList);
		return userList;
	}

	@Override
	public Users getUserById(Integer userId) {
		Users users = new Users();

		try (PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * from users WHERE userId=?");) {
			preparedStatement.setInt(1, userId);
			logger.log(Level.INFO, "selected user id in dao: {0}", userId);

			try (ResultSet resultSet = preparedStatement.executeQuery();) {
				if (resultSet.next()) {
					users.setUserId(resultSet.getInt(USER_ID));
					users.setUsername(resultSet.getString(USERNAME));
					users.setUserPassword(resultSet.getString(USER_PASSWORD));
					users.setUserEmailId(resultSet.getString(USER_EMAIL_ID));
				}
			}
		} catch (SQLException e) {
			logger.log(Level.INFO, e.getMessage(), e);
		}
		logger.log(Level.INFO, "selected User: {0}", users);
		return users;
	}

	@Override
	public Users addUser(Users usersAdd) {
		String query = "INSERT into users (username, userPassword, userEmailId) values(?, ?,?)";

		try (PreparedStatement preparedStatement = connection.prepareStatement(
				query, Statement.RETURN_GENERATED_KEYS);) {
			preparedStatement.setString(1, usersAdd.getUsername());
			preparedStatement.setString(2, usersAdd.getUserPassword());
			preparedStatement.setString(3, usersAdd.getUserEmailId());
			preparedStatement.executeUpdate();

			try (ResultSet resultSet = preparedStatement.getGeneratedKeys();) {
				if (resultSet.next()) {
					logger.log(Level.INFO, "Generated User userId: {0}",
							resultSet.getInt(1));
				}
			}
		} catch (SQLException e) {
			logger.log(Level.INFO, e.getMessage(), e);
		}
		logger.log(Level.INFO, "inserted User: {0}", usersAdd);
		return usersAdd;
	}

	@Override
	public Users updateUser(Users users) {

		String query = "UPDATE Users SET username=?, userPassword=?, userEmailId=? WHERE userId=?";

		try (PreparedStatement preparedStatement = connection
				.prepareStatement(query);) {

			preparedStatement.setString(1, users.getUsername());
			preparedStatement.setString(2, users.getUserPassword());
			preparedStatement.setString(3, users.getUserEmailId());
			preparedStatement.setInt(4, users.getUserId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			logger.log(Level.INFO, e.getMessage(), e);
		}
		logger.log(Level.INFO, "updated User: {0}", users);
		return users;
	}

	@Override
	public Users deleteUser(Integer userId) {
		Users users = getUserById(userId);

		if (users != null) {

			try (PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE from Users WHERE userId=?");) {
				preparedStatement.setInt(1, userId);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				logger.log(Level.INFO, e.getMessage(), e);
			}
		}
		return users;
	}

	@Override
	public Users getUserByUsername(String username) {
		Users users = new Users();

		try (PreparedStatement preparedStatement = connection
				.prepareStatement("select * from users where username=?");) {
			preparedStatement.setString(1, username);

			try (ResultSet resultSet = preparedStatement.executeQuery();) {
				if (resultSet.next()) {
					users.setUserId(resultSet.getInt(USER_ID));
					users.setUsername(resultSet.getString(USERNAME));
					users.setUserPassword(resultSet.getString(USER_PASSWORD));
					users.setUserEmailId(resultSet.getString(USER_EMAIL_ID));
				}
			}
		} catch (SQLException e) {
			logger.log(Level.INFO, e.getMessage(), e);
		}
		logger.log(Level.INFO, "selected User by username: {0}", users);
		return users;
	}

	@Override
	public Users findUserByUserEmailId(String userEmailId, String userPassword) {
		Users users = new Users();

		try (PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * from users WHERE userEmailId=? and userPassword=?");) {
			preparedStatement.setString(1, userEmailId);
			preparedStatement.setString(2, userPassword);

			try (ResultSet resultSet = preparedStatement.executeQuery();) {
				if (resultSet.next()) {
					users.setUserId(resultSet.getInt(USER_ID));
					users.setUsername(resultSet.getString(USERNAME));
					users.setUserPassword(resultSet.getString(USER_PASSWORD));
					users.setUserEmailId(resultSet.getString(USER_EMAIL_ID));
				}
			}
		} catch (SQLException e) {
			logger.log(Level.INFO, e.getMessage(), e);
		}
		logger.log(Level.INFO, "selected User for Authentication: {0}", users);
		return users;
	}
}