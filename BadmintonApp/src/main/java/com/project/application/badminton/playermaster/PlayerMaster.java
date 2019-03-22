package com.project.application.badminton.playermaster;

import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlRootElement;

@Produces("application/json")
@XmlRootElement(name = "PlayerMaster")
public class PlayerMaster {
	private int playerId;
	private String playerName;
	private String playerNickname;
	private String playerMobileNumber;
	private String playerAddress;
	private String playerCity;
	private String playerRole;
	private String playerPassword;
	private boolean playerStatus;

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

	public PlayerMaster() {
	}

	public PlayerMaster(int playerId, String playerName, String playerNickname,
			String playerMobileNumber, String playerAddress, String playerCity,
			String playerRole, String playerPassword, boolean playerStatus) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.playerNickname = playerNickname;
		this.playerMobileNumber = playerMobileNumber;
		this.playerAddress = playerAddress;
		this.playerCity = playerCity;
		this.playerRole = playerRole;
		this.playerPassword = playerPassword;
		this.playerStatus = playerStatus;
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
