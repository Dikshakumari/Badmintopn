package com.iris.badminton.model.persistance.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class PlayerMatch {
	private int playerMatchId;
	// Tournaments(tournamentId)
	private int playerMatchTournamentId;
	// Matches(matchId)
	private int playerMatchMatchId;
	// ClubMaster(clubId)
	private Date playerMatchClubId;
	/* PlayerMaster(playerId) */
	private PlayerMaster playerMatchTeam1Player1;
	private PlayerMaster playerMatchTeam1Player2;
	private PlayerMaster playerMatchTeam2Player1;
	private PlayerMaster playerMatchTeam2Player2;
	private boolean playerMatchStatus;
	private Set<PlayerTournament> playerTournament = new HashSet<>();
}