package com.iris.badminton.model.persistance.dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.badminton.model.persistance.bean.ClubMaster;
import com.iris.badminton.model.persistance.bean.PlayerClub;
import com.iris.badminton.model.persistance.bean.PlayerMaster;

@Repository
public class PlayerClubDaoImplementation implements PlayerClubDao {
	private SessionFactory sessionFactory;
	PlayerMaster playerMaster;
	ClubMaster clubMaster;
	@Autowired
	private PlayerMasterDao playerMasterDao;
	@Autowired
	private ClubMasterDao clubMasterDao;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public PlayerClubDaoImplementation() {
	}

	@Autowired
	public PlayerClubDaoImplementation(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerClub> getAllClubs() {
		return getSession().createQuery("From PlayerClub").list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerClub> getAllClubsWithPlayerId(Integer playerId) {
		//print
		System.out.println("dao is called.."+playerId);
		String query = "from PlayerClub where playerClubPlayerId = :playerId ";
		List<PlayerClub> playerClubs = getSession().createQuery(query)
				.setInteger("playerId", playerId).list();
		if (playerClubs.isEmpty()) {
			return Collections.emptyList();          
		}
		return playerClubs;
	}

	@Override
	public PlayerClub enrolPlayerClubWithLoggedInPlayerId(PlayerClub playerClub) {
		playerMaster = playerMasterDao.getPlayerMasterById(playerClub.getPlayerClubPlayerId().getPlayerId());
		playerClub.setPlayerClubPlayerId(playerMaster);
		
		clubMaster = clubMasterDao.getClubMasterById(playerClub.getPlayerClubClubId().getClubId());
		playerClub.setPlayerClubClubId(clubMaster);
		
		playerClub.setPlayerClubStatus(true);
		getSession().save(playerClub);
		return playerClub;
	}

	@Override
	public void disassociatePlayerClubWithLoggedInPlayerId(
			Integer playerClubId) {
		PlayerClub club = this.getByClubId(playerClubId);
		if(club != null){
			getSession().delete(club);			
		}
	}
	
	public PlayerClub getByClubId(Integer playerClubId) {
		return (PlayerClub) getSession().get(PlayerClub.class, playerClubId);
	}

}