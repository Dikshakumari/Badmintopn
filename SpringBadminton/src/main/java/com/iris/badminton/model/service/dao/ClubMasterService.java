package com.iris.badminton.model.service.dao;

import java.util.List;

import com.iris.badminton.model.persistance.bean.ClubMaster;

public interface ClubMasterService {
	List<ClubMaster> getAllClubs();
	ClubMaster addClubMaster(ClubMaster club);
}