package com.iris.badminton.model.service.dao;

import java.util.List;

import com.iris.badminton.model.persistance.bean.PlayerClub;

public interface PlayerClubService {
	List<PlayerClub> getAllClubs();
	List<PlayerClub> getAllClubsWithPlayerId(Integer playerId);
	PlayerClub enrolPlayerClubWithLoggedInPlayerId(PlayerClub playerClub);
	void disassociatePlayerClubWithLoggedInPlayerId(Integer playerClubId);
}