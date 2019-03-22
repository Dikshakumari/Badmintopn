package com.iris.badminton.model.persistance.dao;

import java.util.List;

import com.iris.badminton.model.persistance.bean.PlayerMaster;

public interface PlayerMasterDao {
	List<PlayerMaster> getAllPlayers();

	PlayerMaster getPlayerMasterById(Integer id);

	PlayerMaster getPlayerMasterByPlayerMobile(String mobileNumber);

	PlayerMaster addPlayerMaster(PlayerMaster master);

	PlayerMaster updatePlayerMaster(PlayerMaster master);

	void deletePlayerMaster(Integer playerId);

	boolean isPlayerMasterExists(PlayerMaster playerMaster);

	PlayerMaster verifyLoginCredentials(String mobileNumber, String password);

}