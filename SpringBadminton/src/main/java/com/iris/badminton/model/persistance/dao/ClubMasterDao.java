package com.iris.badminton.model.persistance.dao;

import java.util.List;

import com.iris.badminton.model.persistance.bean.ClubMaster;

public interface ClubMasterDao {
	List<ClubMaster> getAllClubs();
	ClubMaster addClubMaster(ClubMaster club);
	ClubMaster getClubMasterById(Integer id);
}