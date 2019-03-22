package com.iris.badminton.model.service.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iris.badminton.model.persistance.bean.PlayerClub;
import com.iris.badminton.model.persistance.dao.PlayerClubDao;

@Service
@Transactional
public class PlayerClubServiceImplementation implements PlayerClubService {

	private PlayerClubDao playerClubDao;

	public PlayerClubServiceImplementation() {
	}

	@Autowired
	public PlayerClubServiceImplementation(PlayerClubDao playerClubDao) {
		this.playerClubDao = playerClubDao;
	}

	@Override
	public List<PlayerClub> getAllClubs() {
		return playerClubDao.getAllClubs();
	}

	@Override
	public List<PlayerClub> getAllClubsWithPlayerId(Integer playerId) {
		return playerClubDao.getAllClubsWithPlayerId(playerId);
	}

	@Override
	public PlayerClub enrolPlayerClubWithLoggedInPlayerId(PlayerClub playerClub) {
		return playerClubDao.enrolPlayerClubWithLoggedInPlayerId(playerClub);
	}

	@Override
	public void disassociatePlayerClubWithLoggedInPlayerId(Integer playerClubId) {
		playerClubDao.disassociatePlayerClubWithLoggedInPlayerId(playerClubId);
	}

}