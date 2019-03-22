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
@Table(name = "ClubMaster")
//@JsonIgnoreProperties(ignoreUnknown = true)
public class ClubMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clubId;
	
	@Column(nullable = false)
	private String clubName;
	
	private String clubAddress;
	
	@Column(nullable = false)
	private String clubCity;
	
	@ColumnDefault(value = "true")
	private boolean clubStatus;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "playerClubClubId")
	private Set<PlayerClub> playerclub = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "matchClubId")
	private Set<Matches> match = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "playerMatchClubId")
	private Set<PlayerMatch> playerMatch = new HashSet<>();

	public ClubMaster() {
	}

	public ClubMaster(String clubName, String clubAddress, String clubCity,
			boolean clubStatus) {
		super();
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

	public Set<PlayerClub> getPlayerclub() {
		return playerclub;
	}

	public void setPlayerclub(Set<PlayerClub> playerclub) {
		this.playerclub = playerclub;
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
		builder.append("ClubMaster [clubId=").append(clubId)
				.append(", clubName=").append(clubName)
				.append(", clubAddress=").append(clubAddress)
				.append(", clubCity=").append(clubCity).append(", clubStatus=")
				.append(clubStatus).append("]");
		return builder.toString();
	}

}
