package com.project.application.badminton.clubplayers;

import java.util.List;


public interface ClubPlayersService {
	List<ClubPlayers> listAllClubPlayers();
	List<ClubPlayers> getClubPlayersByPlayerId(Integer clubPlayerPlayerId);
	/*Response getClubPlayerByPlayerId(Integer clubPlayerPlayerId);*/
}