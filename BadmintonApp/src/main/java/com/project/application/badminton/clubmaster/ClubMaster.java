package com.project.application.badminton.clubmaster;

public class ClubMaster {
	private int clubId;
	private String clubName;
	private String clubAddress;
	private String clubCity;
	private boolean clubStatus;

	public ClubMaster() {
	}

	public ClubMaster(int clubId, String clubName, String clubAddress,
			String clubCity, boolean clubStatus) {
		super();
		this.clubId = clubId;
		this.clubName = clubName;
		this.clubAddress = clubAddress;
		this.clubCity = clubCity;
		this.clubStatus = clubStatus;
	}

	public int getClubId() {
		return clubId;
	}

	public void setClubId(int clubId) {
		this.clubId = clubId;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public String getClubAddress() {
		return clubAddress;
	}

	public void setClubAddress(String clubAddress) {
		this.clubAddress = clubAddress;
	}

	public String getClubCity() {
		return clubCity;
	}

	public void setClubCity(String clubCity) {
		this.clubCity = clubCity;
	}

	public boolean isClubStatus() {
		return clubStatus;
	}

	public void setClubStatus(boolean clubStatus) {
		this.clubStatus = clubStatus;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClubMaster [clubId=").append(clubId)
				.append(", clubName=").append(clubName)
				.append(", clubAddress=").append(clubAddress)
				.append(", clubCity=").append(clubCity).append(", clubStatus=")
				.append(clubStatus).append("]");
		return builder.toString();
	}

}
