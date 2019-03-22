package com.iris.badminton.model.service.dao;

import java.util.List;

import com.iris.badminton.model.persistance.bean.PlayerMaster;

public interface PlayerMasterService {
	List<PlayerMaster> listAllPlayerMasters();

	PlayerMaster getPlayerById(Integer playerId);

	PlayerMaster getPlayerMasterByMobileNumber(String playerMobileNumber);

	PlayerMaster addPlayerMaster(PlayerMaster master);

	PlayerMaster updatePlayerMaster(PlayerMaster master);

	void deletePlayerMaster(Integer playerId);

	boolean isPlayerMasterExists(PlayerMaster playerMaster);

	PlayerMaster verifyLoginCredentials(String mobileNumber, String password);
}
