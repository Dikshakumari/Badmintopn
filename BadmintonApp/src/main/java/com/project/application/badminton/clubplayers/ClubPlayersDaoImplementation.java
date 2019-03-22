package com.project.application.badminton.clubplayers;

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

public class ClubPlayersDaoImplementation implements ClubPlayersDao {

	Logger logger = Logger.getLogger(ClubPlayersDaoImplementation.class
			.getName());

	private Connection connection;

	public ClubPlayersDaoImplementation() {
		connection = ConnectionFactory.getConnection();
	}
	
	private static final String CLUBPLAYER_ID = "clubPlayerId";
	private static final String CLUBPLAYER_CLUBID = "clubPlayerClubId";
	private static final String CLUBPLAYER_PLAYERID = "clubPlayerPlayerId";
	private static final String CLUBPLAYER_STATUS = "clubPlayerStatus";

	@Override
	public List<ClubPlayers> getAllClubPlayers() {
		List<ClubPlayers> clubPlayersList = new ArrayList<>();
		try (Statement stmt = connection.createStatement();) {
			try (ResultSet resultSet = stmt.executeQuery("SELECT * from ClubPlayers ORDER BY clubPlayerClubId");) {
				while (resultSet.next()) {					
					ClubPlayers clubPlayers = new ClubPlayers();					
					clubPlayers.setClubPlayerId(resultSet.getInt(CLUBPLAYER_ID));					
					clubPlayers.setClubPlayerClubId(resultSet.getInt(CLUBPLAYER_CLUBID));
					clubPlayers.setClubPlayerPlayerId(resultSet.getInt(CLUBPLAYER_PLAYERID));
					clubPlayers.setClubPlayerStatus(resultSet.getBoolean(CLUBPLAYER_STATUS));
					clubPlayersList.add(clubPlayers);
				}
			}
		} catch (SQLException e) {
			logger.log(Level.INFO, "all", e);
		}
		logger.log(Level.INFO, "club players list: {0}", clubPlayersList);
		return clubPlayersList;
	}
	
	@Override
	public List<ClubPlayers> getClubPlayerByClubPlayerPlayerId(
			Integer clubPlayerPlayerId) {
		List<ClubPlayers> clubPlayersList = new ArrayList<>();
		try (PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * from ClubPlayers WHERE clubPlayerPlayerId=?");) {

			preparedStatement.setInt(1, clubPlayerPlayerId);
			logger.log(Level.INFO, "selected clubplayer player id in dao: {0}", clubPlayerPlayerId);
			
			try (ResultSet resultSet = preparedStatement.executeQuery();) {
				while (resultSet.next()) {					
					ClubPlayers clubPlayers = new ClubPlayers();					
					clubPlayers.setClubPlayerId(resultSet.getInt(CLUBPLAYER_ID));					
					clubPlayers.setClubPlayerClubId(resultSet.getInt(CLUBPLAYER_CLUBID));
					clubPlayers.setClubPlayerPlayerId(resultSet.getInt(CLUBPLAYER_PLAYERID));
					clubPlayers.setClubPlayerStatus(resultSet.getBoolean(CLUBPLAYER_STATUS));
					clubPlayersList.add(clubPlayers);
				}
			}
		} catch (SQLException e) {
			logger.log(Level.INFO, "all", e);
		}
		logger.log(Level.INFO, "club players list with playerId: {0}", clubPlayersList);
		return clubPlayersList;
	}

/*	@Override
	public ClubPlayers getClubPlayerByPlayerId(Integer clubPlayerPlayerId) {
		ClubPlayers clubPlayers = new ClubPlayers();
		try (PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * from ClubPlayers WHERE clubPlayerPlayerId=?");) {
			preparedStatement.setInt(1, clubPlayerPlayerId);
			logger.log(Level.INFO, "selected clubplayer player id in dao: {0}", clubPlayerPlayerId);
			try (ResultSet resultSet = preparedStatement.executeQuery();) {
				if (resultSet.next()) {
					clubPlayers.setClubPlayerId(resultSet.getInt(CLUBPLAYER_ID));					
					clubPlayers.setClubPlayerClubId(resultSet.getInt(CLUBPLAYER_CLUBID));
					clubPlayers.setClubPlayerPlayerId(resultSet.getInt(CLUBPLAYER_PLAYERID));
					clubPlayers.setClubPlayerStatus(resultSet.getBoolean(CLUBPLAYER_STATUS));
				}
			}
		} catch (SQLException e) {
			logger.log(Level.INFO, e.getMessage(), e);
		}
		logger.log(Level.INFO, "selected club player: {0}", clubPlayers);
		return clubPlayers;
	}*/

	@Override
	public void addClubPlayers(Integer clubPlayerClubId) {

	}

	@Override
	public void removeClubPlayers(Integer clubPlayerClubId) {

	}

}