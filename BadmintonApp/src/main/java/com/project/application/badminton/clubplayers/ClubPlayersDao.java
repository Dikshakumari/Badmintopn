package com.project.application.badminton.clubplayers;

import java.util.List;

interface ClubPlayersDao {

	List<ClubPlayers> getAllClubPlayers();
	
	List<ClubPlayers> getClubPlayerByClubPlayerPlayerId(Integer clubPlayerPlayerId);

	/*ClubPlayers getClubPlayerByPlayerId(Integer clubPlayerPlayerId);*/

	void addClubPlayers(Integer clubPlayerClubId);

	//void updatePlayerMaster(PlayerMaster playerMaster);

	void removeClubPlayers(Integer clubPlayerClubId);

	/*boolean isPlayerMasterExists(ClubPlayers playerMaster);

	ClubPlayers findPlayerMasterLoginCredentials(String playerMobileNumber,
			String playerPassword);
*/
}