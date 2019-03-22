package com.iris.badminton.web.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iris.badminton.model.persistance.bean.ClubMaster;
import com.iris.badminton.model.service.dao.ClubMasterService;

@RestController
@RequestMapping(headers = "Accept=application/json")
public class ClubMasterController {
	private static final Logger LOGGER = Logger.getLogger(ClubMasterController.class.getName());
	private ClubMasterService service;

	public ClubMasterController() {
	}
	
	@Autowired
	public ClubMasterController(ClubMasterService service) {
		this.service = service;
	}
	
	// -------------------Retrieve All Clubs----------------------------------
	@RequestMapping(value = "/clubs", method = RequestMethod.GET)
	public ResponseEntity<List<ClubMaster>> listAllClubMasters() {
		List<ClubMaster> list = service.getAllClubs();
		if (list.isEmpty()) {
			LOGGER.log(Level.INFO, "List is empty.");
			return new ResponseEntity<List<ClubMaster>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<ClubMaster>>(list, HttpStatus.OK);
	}
	
	// -------------------Create a Club---------------------------------------
	@RequestMapping(value = "/clubs", method = RequestMethod.POST)
	public ResponseEntity<ClubMaster> addClubMaster(@RequestBody ClubMaster master) {
		service.addClubMaster(master);
		LOGGER.log(Level.INFO, "generated ID: {0}", master.getClubId());
		return new ResponseEntity<ClubMaster>(master, HttpStatus.OK);			
	}

}