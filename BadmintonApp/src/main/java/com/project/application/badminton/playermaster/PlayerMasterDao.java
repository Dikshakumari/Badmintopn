package com.project.application.badminton.playermaster;

import java.util.List;

public interface PlayerMasterDao {

	List<PlayerMaster> getAllPlayerMasters();

	PlayerMaster getPlayerMasterByMobileNumber(String playerMobileNumber);

	PlayerMaster getPlayerById(Integer playerId);

	void addPlayerMaster(PlayerMaster playerMaster);

	void updatePlayerMaster(PlayerMaster playerMaster);

	void deletePlayerMaster(Integer playerId);

	boolean isPlayerMasterExists(PlayerMaster playerMaster);

	PlayerMaster findPlayerMasterLoginCredentials(String playerMobileNumber,
			String playerPassword);

}