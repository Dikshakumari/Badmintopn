package com.project.application.badminton.playermaster;

import java.util.List;

import javax.ws.rs.core.Response;

import com.project.application.exceptions.PlayerMasterAlreadyExistException;
import com.project.application.exceptions.PlayerMasterDoesNotExistWithThePlayerId;
import com.project.application.exceptions.UnmatchingPlayerMasterCredentialsException;

public interface PlayerMasterService {
	List<PlayerMaster> listAllPlayerMasters();

	Response getPlayerMasterByMobileNumber(String playerMobileNumber);

	PlayerMaster getPlayerById(Integer playerId);

	void addPlayerMaster(PlayerMaster playerMaster) throws PlayerMasterAlreadyExistException;
	
	void updatePlayerMaster(Integer playerId, PlayerMaster playerMaster) throws PlayerMasterDoesNotExistWithThePlayerId;

	Response deletePlayerMaster(Integer playerId);

	boolean isPlayerMasterExists(PlayerMaster playerMaster);

	PlayerMaster isValidPlayerMaster(String playerMobileNumber,
			String playerPassword) throws UnmatchingPlayerMasterCredentialsException;
}
