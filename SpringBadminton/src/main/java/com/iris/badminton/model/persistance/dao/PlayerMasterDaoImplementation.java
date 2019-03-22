package com.iris.badminton.model.persistance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.badminton.model.persistance.bean.PlayerMaster;

@Repository
public class PlayerMasterDaoImplementation implements PlayerMasterDao {

	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public PlayerMasterDaoImplementation() {
	}

	@Autowired
	public PlayerMasterDaoImplementation(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerMaster> getAllPlayers() {
		return getSession().createQuery("From PlayerMaster").list();
	}

	@Override
	public PlayerMaster getPlayerMasterById(Integer id) {
		return (PlayerMaster) getSession().get(PlayerMaster.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PlayerMaster getPlayerMasterByPlayerMobile(String mobileNumber) {
		PlayerMaster master = null;
		String query = "from PlayerMaster where playerMobileNumber = :mobileNumber ";

		List<PlayerMaster> mastersList = getSession().createQuery(query)
				.setString("mobileNumber", mobileNumber).list();
		if (!mastersList.isEmpty()) {
			master = mastersList.get(0);
		}
		return master;
	}

	@Override
	public PlayerMaster addPlayerMaster(PlayerMaster master) {
		getSession().save(master);
		return master;
	}

	@Override
	public PlayerMaster updatePlayerMaster(PlayerMaster master) {
		getSession().merge(master);
		return master;
	}

	@Override
	public void deletePlayerMaster(Integer playerId) {
		PlayerMaster master = getPlayerMasterById(playerId);
		if (master != null) {
			getSession().delete(master);
		}
		// else throw invalid player id or player not found exception
	}

	@Override
	public boolean isPlayerMasterExists(PlayerMaster playerMaster) {

		playerMaster = getPlayerMasterByPlayerMobile(playerMaster.getPlayerMobileNumber());
		if (playerMaster == null)
			return false;
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PlayerMaster verifyLoginCredentials(String mobileNumber,
			String password) {
		PlayerMaster master = null;
		String query = "from PlayerMaster pm where pm.playerMobileNumber = ? and pm.playerPassword = ?";

		List<PlayerMaster> mastersList = getSession().createQuery(query)
				.setString(0, mobileNumber).setString(1, password).list();
		if (!mastersList.isEmpty()) {
			master = mastersList.get(0);
		}
		return master;
	}

}