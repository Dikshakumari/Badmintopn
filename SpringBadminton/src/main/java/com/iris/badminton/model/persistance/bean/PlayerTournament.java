package com.iris.badminton.model.persistance.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;

public class PlayerTournament {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int playerTournamentId;

	// Tournaments(tournamentId)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "playerTournamentTournamentId")
	private Tournament playerTournamentTournamentId;

	// PlayerMaster(PlayerId)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "playerTournamentPlayerId")
	private PlayerMaster playerTournamentPlayerId;

	private Date playerTournamentRegistrationDate;

	@ColumnDefault(value = "true")
	private boolean playerTournamentStatus;
}
/*
 * tournamentPlayerId int NOT NULL PRIMARY KEY auto_increment,
 * tournamentPlayerTournamentId int NOT NULL, tournamentPlayerPlayerId int NOT
 * NULL, tournamentPlayerRegistrationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 * tournamentPlayerStatus bit Default 0,
 */