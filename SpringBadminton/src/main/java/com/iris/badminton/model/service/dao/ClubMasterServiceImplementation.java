package com.iris.badminton.model.service.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iris.badminton.model.persistance.bean.ClubMaster;
import com.iris.badminton.model.persistance.dao.ClubMasterDao;

@Service
@Transactional
public class ClubMasterServiceImplementation implements ClubMasterService {

	private ClubMasterDao dao;

	public ClubMasterServiceImplementation() {
	}

	@Autowired
	public ClubMasterServiceImplementation(ClubMasterDao dao) {
		this.dao = dao;
	}

	@Override
	public List<ClubMaster> getAllClubs() {
		return dao.getAllClubs();
	}

	@Override
	public ClubMaster addClubMaster(ClubMaster club) {
		return dao.addClubMaster(club);
	}
	
	public ClubMaster getClubById(Integer clubId) {
		return dao.getClubMasterById(clubId);
	}

}