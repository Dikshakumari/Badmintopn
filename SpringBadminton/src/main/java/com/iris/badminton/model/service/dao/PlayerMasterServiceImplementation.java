package com.iris.badminton.model.service.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iris.badminton.model.persistance.bean.PlayerMaster;
import com.iris.badminton.model.persistance.dao.PlayerMasterDao;

@Service
@Transactional
public class PlayerMasterServiceImplementation implements PlayerMasterService {

	private PlayerMasterDao playerMasterDao;

	public PlayerMasterServiceImplementation() {
	}

	@Autowired
	public PlayerMasterServiceImplementation(PlayerMasterDao playerMasterDao) {
		this.playerMasterDao = playerMasterDao;
	}

	@Override
	public List<PlayerMaster> listAllPlayerMasters() {
		return playerMasterDao.getAllPlayers();
	}

	@Override
	public PlayerMaster getPlayerById(Integer playerId) {
		return playerMasterDao.getPlayerMasterById(playerId);
	}

	@Override
	public PlayerMaster getPlayerMasterByMobileNumber(String playerMobileNumber) {
		PlayerMaster master = playerMasterDao.getPlayerMasterByPlayerMobile(playerMobileNumber);
		if (master == null)
			// throw exception here
			return null;
		return master;
	}

	@Override
	public PlayerMaster addPlayerMaster(PlayerMaster master) {
		return playerMasterDao.addPlayerMaster(master);
	}

	@Override
	public PlayerMaster updatePlayerMaster(PlayerMaster master) {
		return playerMasterDao.updatePlayerMaster(master);
	}

	@Override
	public void deletePlayerMaster(Integer playerId) {
		playerMasterDao.deletePlayerMaster(playerId);
	}

	@Override
	public boolean isPlayerMasterExists(PlayerMaster playerMaster) {
		return playerMasterDao.isPlayerMasterExists(playerMaster);
	}

	@Override
	public PlayerMaster verifyLoginCredentials(String mobileNumber,
			String password) {
		return playerMasterDao.verifyLoginCredentials(mobileNumber, password);
	}

}