package com.iris.badminton.model.persistance.bean;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "PlayerClub")
public class PlayerClub {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int playerClubId;
	
	// PlayerMaster(PlayerId)
	@ManyToOne(fetch = FetchType.EAGER)
	private PlayerMaster playerClubPlayerId;

	// ClubMaster(clubId)
	@ManyToOne(fetch = FetchType.EAGER)
	private ClubMaster playerClubClubId;
	
	@ColumnDefault(value = "true")
	private boolean playerClubStatus;

	public int getPlayerClubId() {
		return playerClubId;
	}

	public void setPlayerClubId(int playerClubId) {
		this.playerClubId = playerClubId;
	}

	public PlayerMaster getPlayerClubPlayerId() {
		return playerClubPlayerId;
	}

	public void setPlayerClubPlayerId(PlayerMaster playerClubPlayerId) {
		this.playerClubPlayerId = playerClubPlayerId;
	}

	public ClubMaster getPlayerClubClubId() {
		return playerClubClubId;
	}

	public void setPlayerClubClubId(ClubMaster playerClubClubId) {
		this.playerClubClubId = playerClubClubId;
	}

	public boolean isPlayerClubStatus() {
		return playerClubStatus;
	}

	public void setPlayerClubStatus(boolean playerClubStatus) {
		this.playerClubStatus = playerClubStatus;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PlayerClub [playerClubId=").append(playerClubId)
				.append(", playerClubPlayerId=").append(playerClubPlayerId)
				.append(", playerClubClubId=").append(playerClubClubId)
				.append(", playerClubStatus=").append(playerClubStatus)
				.append("]");
		return builder.toString();
	}

}
