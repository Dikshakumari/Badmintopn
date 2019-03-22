package com.project.application.badminton.clubmaster;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.project.application.model.connection.ConnectionFactory;

public class ClubMasterDaoImplementation{
	Logger logger = Logger.getLogger(ClubMasterDaoImplementation.class
			.getName());

	private Connection connection;

	public ClubMasterDaoImplementation() {
		connection = ConnectionFactory.getConnection();
	}
	
	private static final String CLUB_ID = "clubId";
	private static final String CLUB_NAME = "clubName";
	private static final String CLUB_ADDRESS = "clubAddress";
	private static final String CLUB_CITY = "clubCity";
	private static final String CLUB_STATUS = "clubStatus";
	
	public List<ClubMaster> getAllClubMasters() {
		List<ClubMaster> clubMasterList = new ArrayList<>();

		try (Statement stmt = connection.createStatement();) {

			try (ResultSet resultSet = stmt.executeQuery("SELECT * from ClubMaster ORDER BY clubName");) {
				while (resultSet.next()) {					
					ClubMaster clubMaster = new ClubMaster();
					
					clubMaster.setClubId(resultSet.getInt(CLUB_ID));
					clubMaster.setClubName(resultSet.getString(CLUB_NAME));
					clubMaster.setClubAddress(resultSet.getString(CLUB_ADDRESS));
					clubMaster.setClubCity(resultSet.getString(CLUB_CITY));
					clubMaster.setClubStatus(resultSet.getBoolean(CLUB_STATUS));

					clubMasterList.add(clubMaster);
				}
			}
		} catch (SQLException e) {
			logger.log(Level.INFO, "all", e);
		}
		logger.log(Level.INFO, "club masters list: {0}", clubMasterList);
		return clubMasterList;
	}
	
}