package com.iris.badminton.model.persistance.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Tournament {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tournamentId;

	@Column(nullable = false)
	private String tournamentName;

	private String tournamentDescription;

	@Column(nullable = false)
	private String tournamentType;

	@Column(nullable = false)
	private Date tournamentStartDate;

	@Column(nullable = false)
	private Date tournamentEndDate;

	@Column(nullable = false)
	private Date tournamentLastDateOfEnrollment;

	@Column(nullable = false, columnDefinition = "date default sysdate")
	private Date tournamentCreationDate;

	@ColumnDefault(value = "true")
	private boolean tournamentStatus;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "playerTournamentTournamentId")
	private Set<PlayerTournament> playerTournament = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "match")
	private Set<Matches> match = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "playerMatch")
	private Set<PlayerMatch> playerMatch = new HashSet<>();

	public int getTournamentId() {
		return tournamentId;
	}

	public void setTournamentId(int tournamentId) {
		this.tournamentId = tournamentId;
	}

	public String getTournamentName() {
		return tournamentName;
	}

	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}

	public String getTournamentDescription() {
		return tournamentDescription;
	}

	public void setTournamentDescription(String tournamentDescription) {
		this.tournamentDescription = tournamentDescription;
	}

	public String getTournamentType() {
		return tournamentType;
	}

	public void setTournamentType(String tournamentType) {
		this.tournamentType = tournamentType;
	}

	public Date getTournamentStartDate() {
		return tournamentStartDate;
	}

	public void setTournamentStartDate(Date tournamentStartDate) {
		this.tournamentStartDate = tournamentStartDate;
	}

	public Date getTournamentEndDate() {
		return tournamentEndDate;
	}

	public void setTournamentEndDate(Date tournamentEndDate) {
		this.tournamentEndDate = tournamentEndDate;
	}

	public Date getTournamentLastDateOfEnrollment() {
		return tournamentLastDateOfEnrollment;
	}

	public void setTournamentLastDateOfEnrollment(
			Date tournamentLastDateOfEnrollment) {
		this.tournamentLastDateOfEnrollment = tournamentLastDateOfEnrollment;
	}

	public Date getTournamentCreationDate() {
		return tournamentCreationDate;
	}

	public void setTournamentCreationDate(Date tournamentCreationDate) {
		this.tournamentCreationDate = tournamentCreationDate;
	}

	public boolean isTournamentStatus() {
		return tournamentStatus;
	}

	public void setTournamentStatus(boolean tournamentStatus) {
		this.tournamentStatus = tournamentStatus;
	}

	public Set<PlayerTournament> getPlayerTournament() {
		return playerTournament;
	}

	public void setPlayerTournament(Set<PlayerTournament> playerTournament) {
		this.playerTournament = playerTournament;
	}

	public Set<Matches> getMatch() {
		return match;
	}

	public void setMatch(Set<Matches> match) {
		this.match = match;
	}

	public Set<PlayerMatch> getPlayerMatch() {
		return playerMatch;
	}

	public void setPlayerMatch(Set<PlayerMatch> playerMatch) {
		this.playerMatch = playerMatch;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tournament [tournamentId=").append(tournamentId)
				.append(", tournamentName=").append(tournamentName)
				.append(", tournamentDescription=")
				.append(tournamentDescription).append(", tournamentType=")
				.append(tournamentType).append(", tournamentStartDate=")
				.append(tournamentStartDate).append(", tournamentEndDate=")
				.append(tournamentEndDate)
				.append(", tournamentLastDateOfEnrollment=")
				.append(tournamentLastDateOfEnrollment)
				.append(", tournamentCreationDate=")
				.append(tournamentCreationDate).append(", tournamentStatus=")
				.append(tournamentStatus).append("]");
		return builder.toString();
	}

}