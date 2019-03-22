package com.iris.badminton.model.persistance.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "PlayerMaster")
// @Proxy(lazy = false)
// @JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int playerId;

	@Column(nullable = false)
	private String playerName;

	private String playerNickname;

	@Column(nullable = false, unique = true)
	private String playerMobileNumber;

	private String playerAddress;

	private String playerCity;

	private String playerRole;

	@Column(nullable = false)
	private String playerPassword;

	@ColumnDefault(value = "true")
	private boolean playerStatus;

	// nullable = false @OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "playerClubPlayerId")
	private Set<PlayerClub> playerclub = new HashSet<>();

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "playerTournamentPlayerId")
	private Set<PlayerTournament> playerTournament = new HashSet<>();

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "playerMatchTeam1Player1PlayerId")
	private Set<PlayerMatch> playerMatchPlayer1 = new HashSet<>();
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "playerMatchTeam1Player2PlayerId")
	private Set<PlayerMatch> playerMatchPlayer2 = new HashSet<>();
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "playerMatchTeam2Player1PlayerId")
	private Set<PlayerMatch> playerMatchPlayer3 = new HashSet<>();
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "playerMatchTeam2Player2PlayerId")
	private Set<PlayerMatch> playerMatchPlayer4 = new HashSet<>();

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerNickname() {
		return playerNickname;
	}

	public void setPlayerNickname(String playerNickname) {
		this.playerNickname = playerNickname;
	}

	public String getPlayerMobileNumber() {
		return playerMobileNumber;
	}

	public void setPlayerMobileNumber(String playerMobileNumber) {
		this.playerMobileNumber = playerMobileNumber;
	}

	public String getPlayerAddress() {
		return playerAddress;
	}

	public void setPlayerAddress(String playerAddress) {
		this.playerAddress = playerAddress;
	}

	public String getPlayerCity() {
		return playerCity;
	}

	public void setPlayerCity(String playerCity) {
		this.playerCity = playerCity;
	}

	public String getPlayerRole() {
		return playerRole;
	}

	public void setPlayerRole(String playerRole) {
		this.playerRole = playerRole;
	}

	public String getPlayerPassword() {
		return playerPassword;
	}

	public void setPlayerPassword(String playerPassword) {
		this.playerPassword = playerPassword;
	}

	public boolean isPlayerStatus() {
		return playerStatus;
	}

	public void setPlayerStatus(boolean playerStatus) {
		this.playerStatus = playerStatus;
	}

	public Set<PlayerClub> getPlayerclub() {
		return playerclub;
	}

	public void setPlayerclub(Set<PlayerClub> playerclub) {
		this.playerclub = playerclub;
	}

	public Set<PlayerTournament> getPlayerTournament() {
		return playerTournament;
	}

	public void setPlayerTournament(Set<PlayerTournament> playerTournament) {
		this.playerTournament = playerTournament;
	}

	public Set<PlayerMatch> getPlayerMatchPlayer1() {
		return playerMatchPlayer1;
	}

	public void setPlayerMatchPlayer1(Set<PlayerMatch> playerMatchPlayer1) {
		this.playerMatchPlayer1 = playerMatchPlayer1;
	}

	public Set<PlayerMatch> getPlayerMatchPlayer2() {
		return playerMatchPlayer2;
	}

	public void setPlayerMatchPlayer2(Set<PlayerMatch> playerMatchPlayer2) {
		this.playerMatchPlayer2 = playerMatchPlayer2;
	}

	public Set<PlayerMatch> getPlayerMatchPlayer3() {
		return playerMatchPlayer3;
	}

	public void setPlayerMatchPlayer3(Set<PlayerMatch> playerMatchPlayer3) {
		this.playerMatchPlayer3 = playerMatchPlayer3;
	}

	public Set<PlayerMatch> getPlayerMatchPlayer4() {
		return playerMatchPlayer4;
	}

	public void setPlayerMatchPlayer4(Set<PlayerMatch> playerMatchPlayer4) {
		this.playerMatchPlayer4 = playerMatchPlayer4;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PlayerMaster [playerId=").append(playerId)
				.append(", playerName=").append(playerName)
				.append(", playerNickname=").append(playerNickname)
				.append(", playerMobileNumber=").append(playerMobileNumber)
				.append(", playerAddress=").append(playerAddress)
				.append(", playerCity=").append(playerCity)
				.append(", playerRole=").append(playerRole)
				.append(", playerPassword=").append(playerPassword)
				.append(", playerStatus=").append(playerStatus).append("]");
		return builder.toString();
	}

}