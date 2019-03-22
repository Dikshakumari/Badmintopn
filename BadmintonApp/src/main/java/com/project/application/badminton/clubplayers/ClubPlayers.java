package com.project.application.badminton.clubplayers;

public class ClubPlayers {
	private int clubPlayerId;
	// ClubMaster(clubId)
	private int clubPlayerClubId;
	// PlayerMaster(PlayerId)
	private int clubPlayerPlayerId;
	private boolean clubPlayerStatus;

	public ClubPlayers() {
	}

	public ClubPlayers(int clubPlayerId, int clubPlayerClubId,
			int clubPlayerPlayerId, boolean clubPlayerStatus) {
		super();
		this.clubPlayerId = clubPlayerId;
		this.clubPlayerClubId = clubPlayerClubId;
		this.clubPlayerPlayerId = clubPlayerPlayerId;
		this.clubPlayerStatus = clubPlayerStatus;
	}

	public int getClubPlayerId() {
		return clubPlayerId;
	}

	public void setClubPlayerId(int clubPlayerId) {
		this.clubPlayerId = clubPlayerId;
	}

	public int getClubPlayerClubId() {
		return clubPlayerClubId;
	}

	public void setClubPlayerClubId(int clubPlayerClubId) {
		this.clubPlayerClubId = clubPlayerClubId;
	}

	public int getClubPlayerPlayerId() {
		return clubPlayerPlayerId;
	}

	public void setClubPlayerPlayerId(int clubPlayerPlayerId) {
		this.clubPlayerPlayerId = clubPlayerPlayerId;
	}

	public boolean isClubPlayerStatus() {
		return clubPlayerStatus;
	}

	public void setClubPlayerStatus(boolean clubPlayerStatus) {
		this.clubPlayerStatus = clubPlayerStatus;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClubPlayers [clubPlayerId=").append(clubPlayerId)
				.append(", clubPlayerClubId=").append(clubPlayerClubId)
				.append(", clubPlayerPlayerId=").append(clubPlayerPlayerId)
				.append(", clubPlayerStatus=").append(clubPlayerStatus)
				.append("]");
		return builder.toString();
	}

}