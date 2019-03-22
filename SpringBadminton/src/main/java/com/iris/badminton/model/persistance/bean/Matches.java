package com.iris.badminton.model.persistance.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Matches {
	private int matchId;
	// Tournaments(tournamentId) 
	private int matchTournamentId;
	// ClubMaster(clubId)
	private int matchClubId;
	private Date matchGameFormatId;
	private int matchNo;
	private int matchPointOf;
	private int dateOfMatch;
	private boolean matchStatus;
	private Set<PlayerTournament> playerTournament = new HashSet<>();
}
/*	matchId int NOT NULL PRIMARY KEY auto_increment,
	matchTournamentId int,
	matchClubId int,
	matchGameFormatId enum('Single','Double') DEFAULT 'Single' NOT NULL,
	matchNo VarChar(128),
	matchPointOf Int Default 21,
	dateOfMatch TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	matchStatus int Default 0,
 FOREIGN KEY fkM01(matchTournamentId) REFERENCES Tournaments(tournamentId) ON UPDATE CASCADE ON DELETE RESTRICT,
 FOREIGN KEY fkM02(matchClubId) REFERENCES ClubMaster(clubId) ON UPDATE CASCADE ON DELETE RESTRICT*/