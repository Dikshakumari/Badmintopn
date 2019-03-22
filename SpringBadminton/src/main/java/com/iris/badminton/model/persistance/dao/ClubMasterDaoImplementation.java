package com.iris.badminton.model.persistance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.badminton.model.persistance.bean.ClubMaster;

@Repository
public class ClubMasterDaoImplementation implements ClubMasterDao {
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public ClubMasterDaoImplementation() {
	}

	@Autowired
	public ClubMasterDaoImplementation(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClubMaster> getAllClubs() {
		return getSession().createQuery("From ClubMaster").list();
	}

	@Override
	public ClubMaster addClubMaster(ClubMaster club) {
		getSession().save(club);
		return club;
	}
	
	@Override
	public ClubMaster getClubMasterById(Integer id) {
		return (ClubMaster) getSession().get(ClubMaster.class, id);
	}

}