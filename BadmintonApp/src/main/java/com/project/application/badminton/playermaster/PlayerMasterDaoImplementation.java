package com.project.application.badminton.playermaster;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.project.application.model.connection.ConnectionFactory;

public class PlayerMasterDaoImplementation implements PlayerMasterDao {
	
	Logger logger = Logger.getLogger(PlayerMasterDaoImplementation.class
			.getName());
	
	private Connection connection;
	public PlayerMasterDaoImplementation() {
		connection = ConnectionFactory.getConnection();
	}
	
	private static final String PLAYER_ID = "playerId";
	private static final String PLAYER_NAME = "playerName";
	private static final String PLAYER_NICKNAME = "playerNickname";
	private static final String PLAYER_MOBILE_NUMBER = "playerMobileNumber";
	private static final String PLAYER_ADDRESS = "playerAddress";
	private static final String PLAYER_CITY = "playerCity";
	private static final String PLAYER_ROLE = "playerRole";
	private static final String PLAYER_PASSWORD = "playerPassword";
	private static final String PLAYER_STATUS = "playerStatus";
	
	@Override
	public List<PlayerMaster> getAllPlayerMasters() {
		List<PlayerMaster> playerMastersList = new ArrayList<>();

		try (Statement stmt = connection.createStatement();) {

			try (ResultSet resultSet = stmt.executeQuery("SELECT * from PlayerMaster ORDER BY playerName");) {
				while (resultSet.next()) {					
					PlayerMaster playerMaster = new PlayerMaster();
					playerMaster.setPlayerId(resultSet.getInt(PLAYER_ID));
					playerMaster.setPlayerName(resultSet.getString(PLAYER_NAME));
					playerMaster.setPlayerNickname(resultSet.getString(PLAYER_NICKNAME));
					playerMaster.setPlayerMobileNumber(resultSet.getString(PLAYER_MOBILE_NUMBER));
					playerMaster.setPlayerAddress(resultSet.getString(PLAYER_ADDRESS));
					playerMaster.setPlayerCity(resultSet.getString(PLAYER_CITY));
					playerMaster.setPlayerRole(resultSet.getString(PLAYER_ROLE));
					playerMaster.setPlayerPassword(resultSet.getString(PLAYER_PASSWORD));
					playerMaster.setPlayerStatus(resultSet.getBoolean(PLAYER_STATUS));

					playerMastersList.add(playerMaster);
				}
			}
		} catch (SQLException e) {
			logger.log(Level.INFO, "all", e);
		}
		logger.log(Level.INFO, "player master list: {0}", playerMastersList);
		return playerMastersList;
	}

	@Override
	public PlayerMaster getPlayerMasterByMobileNumber(String playerMobileNumber) {
		PlayerMaster playerMaster = new PlayerMaster();

		try (PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * from PlayerMaster WHERE playerMobileNumber=?");) {
			preparedStatement.setString(1, playerMobileNumber);
			logger.log(Level.INFO, "selected player mobile number in dao: {0}", playerMobileNumber);

			try (ResultSet resultSet = preparedStatement.executeQuery();) {
				if (resultSet.next()) {
					playerMaster.setPlayerId(resultSet.getInt(PLAYER_ID));
					playerMaster.setPlayerName(resultSet.getString(PLAYER_NAME));
					playerMaster.setPlayerNickname(resultSet.getString(PLAYER_NICKNAME));
					playerMaster.setPlayerMobileNumber(resultSet.getString(PLAYER_MOBILE_NUMBER));
					playerMaster.setPlayerAddress(resultSet.getString(PLAYER_ADDRESS));
					playerMaster.setPlayerCity(resultSet.getString(PLAYER_CITY));
					playerMaster.setPlayerRole(resultSet.getString(PLAYER_ROLE));
					playerMaster.setPlayerPassword(resultSet.getString(PLAYER_PASSWORD));
					playerMaster.setPlayerStatus(resultSet.getBoolean(PLAYER_STATUS));
				}
			}
		} catch (SQLException e) {
			logger.log(Level.INFO, e.getMessage(), e);
		}
		logger.log(Level.INFO, "selected player master: {0}", playerMaster);
		return playerMaster;
	}

	@Override
	public PlayerMaster getPlayerById(Integer playerId) {
		PlayerMaster playerMaster = new PlayerMaster();

		try (PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * from PlayerMaster WHERE playerId=?");) {
			preparedStatement.setInt(1, playerId);
			logger.log(Level.INFO, "selected player id in dao: {0}", playerId);

			try (ResultSet resultSet = preparedStatement.executeQuery();) {
				if (resultSet.next()) {
					playerMaster.setPlayerId(resultSet.getInt(PLAYER_ID));
					playerMaster.setPlayerName(resultSet.getString(PLAYER_NAME));
					playerMaster.setPlayerNickname(resultSet.getString(PLAYER_NICKNAME));
					playerMaster.setPlayerMobileNumber(resultSet.getString(PLAYER_MOBILE_NUMBER));
					playerMaster.setPlayerAddress(resultSet.getString(PLAYER_ADDRESS));
					playerMaster.setPlayerCity(resultSet.getString(PLAYER_CITY));
					playerMaster.setPlayerRole(resultSet.getString(PLAYER_ROLE));
					playerMaster.setPlayerPassword(resultSet.getString(PLAYER_PASSWORD));
					playerMaster.setPlayerStatus(resultSet.getBoolean(PLAYER_STATUS));
				}
			}
		} catch (SQLException e) {
			logger.log(Level.INFO, e.getMessage(), e);
		}
		logger.log(Level.INFO, "selected player master: {0}", playerMaster);
		return playerMaster;
	}

	@Override
	public void addPlayerMaster(PlayerMaster addPlayerMaster) {
		String query = "INSERT into PlayerMaster (playerName, playerNickname, playerMobileNumber, playerAddress, playerCity, playerPassword) values(? ,? ,? ,? ,? ,?)";

		try (PreparedStatement preparedStatement = connection.prepareStatement(
				query, Statement.RETURN_GENERATED_KEYS);) {
			preparedStatement.setString(1, addPlayerMaster.getPlayerName());
			preparedStatement.setString(2, addPlayerMaster.getPlayerNickname());
			preparedStatement.setString(3, addPlayerMaster.getPlayerMobileNumber());
			preparedStatement.setString(4, addPlayerMaster.getPlayerAddress());
			preparedStatement.setString(5, addPlayerMaster.getPlayerCity());
			preparedStatement.setString(6, addPlayerMaster.getPlayerPassword());
			
			preparedStatement.executeUpdate();

			try (ResultSet resultSet = preparedStatement.getGeneratedKeys();) {
				if (resultSet.next()) {
					logger.log(Level.INFO, "Generated PlayerMaster playerId: {0}",
							resultSet.getInt(1));
				}
			}
		} catch (SQLException e) {
			logger.log(Level.INFO, e.getMessage(), e);
		}
		logger.log(Level.INFO, "inserted PlayerMaster: {0}", addPlayerMaster);
		
	}

	@Override
	public void updatePlayerMaster(PlayerMaster addPlayerMaster) {
		String query = "UPDATE PlayerMaster SET playerMobileNumber=?, playerAddress=?, playerCity=?, playerPassword=? WHERE playerId=?";

		try (PreparedStatement preparedStatement = connection
				.prepareStatement(query);){
			preparedStatement.setString(1, addPlayerMaster.getPlayerMobileNumber());
			preparedStatement.setString(2, addPlayerMaster.getPlayerAddress());
			preparedStatement.setString(3, addPlayerMaster.getPlayerCity());
			preparedStatement.setString(4, addPlayerMaster.getPlayerPassword());
			preparedStatement.setInt(5, addPlayerMaster.getPlayerId());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			logger.log(Level.INFO, e.getMessage(), e);
		}
		logger.log(Level.INFO, "updated PlayerMaster: {0}", addPlayerMaster);
		
	}

	@Override
	public void deletePlayerMaster(Integer playerId) {
		PlayerMaster playerMaster=getPlayerById(playerId);

		if (playerMaster != null) 

			try (PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE from PlayerMaster WHERE playerId=?");) {
				preparedStatement.setInt(1, playerId);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				logger.log(Level.INFO, e.getMessage(), e);
			}
		
	}

	@Override
	public boolean isPlayerMasterExists(PlayerMaster playerMaster) {
		boolean isPlayerMasterExists=false;
		try (PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT playerName from PlayerMaster WHERE playerMobileNumber=?");) {
			preparedStatement.setString(1, playerMaster.getPlayerMobileNumber());
			logger.log(Level.INFO, "selected player in dao: {0}", playerMaster.getPlayerMobileNumber());

			try (ResultSet resultSet = preparedStatement.executeQuery();) {
				if(resultSet.next()){
					playerMaster.setPlayerName(resultSet.getString(PLAYER_NAME));
					
					logger.log(Level.INFO, "playername: {0}", resultSet.getString(PLAYER_NAME));
					
					if (resultSet.getString(PLAYER_NAME) != null) {
					isPlayerMasterExists = true;
					}
				}				
			}
		} catch (SQLException e) {
			logger.log(Level.INFO, e.getMessage(), e);
		}
		logger.log(Level.INFO, "getMobile number PlayerMaster: {0}", playerMaster.getPlayerMobileNumber());
		return isPlayerMasterExists;
	}

	@Override
	public PlayerMaster findPlayerMasterLoginCredentials(
			String playerMobileNumber, String playerPassword) {
		
		PlayerMaster playerMaster = new PlayerMaster();

		try (PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * from PlayerMaster WHERE playerMobileNumber=? and playerPassword=?");) {
			preparedStatement.setString(1, playerMobileNumber);
			preparedStatement.setString(2, playerPassword);

			try (ResultSet resultSet = preparedStatement.executeQuery();) {
				if (resultSet.next()) {
					playerMaster.setPlayerId(resultSet.getInt(PLAYER_ID));
					playerMaster.setPlayerName(resultSet.getString(PLAYER_NAME));
					playerMaster.setPlayerNickname(resultSet.getString(PLAYER_NICKNAME));
					playerMaster.setPlayerMobileNumber(resultSet.getString(PLAYER_MOBILE_NUMBER));
					playerMaster.setPlayerAddress(resultSet.getString(PLAYER_ADDRESS));
					playerMaster.setPlayerCity(resultSet.getString(PLAYER_CITY));
					playerMaster.setPlayerRole(resultSet.getString(PLAYER_ROLE));
					playerMaster.setPlayerPassword(resultSet.getString(PLAYER_PASSWORD));
					playerMaster.setPlayerStatus(resultSet.getBoolean(PLAYER_STATUS));
				}
			}
		} catch (SQLException e) {
			logger.log(Level.INFO, e.getMessage(), e);
		}
		logger.log(Level.INFO, "selected player master for Authentication: {0}", playerMaster);
		return playerMaster;
	}

}
