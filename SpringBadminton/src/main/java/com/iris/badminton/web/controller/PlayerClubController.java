package com.iris.badminton.web.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iris.badminton.model.persistance.bean.PlayerClub;
import com.iris.badminton.model.service.dao.PlayerClubService;

@RestController
@RequestMapping(headers = "Accept=application/json")
public class PlayerClubController {
	private static final Logger LOGGER = Logger.getLogger(PlayerClubController.class.getName());
	private PlayerClubService playerClubService;

	public PlayerClubController() {
	}

	@Autowired
	public PlayerClubController(PlayerClubService playerClubService) {
		this.playerClubService = playerClubService;
	}
	
	// -------------------Retrieve All Player Club------------------------
	@RequestMapping(value = "/enrolled", method = RequestMethod.GET)
	public ResponseEntity<List<PlayerClub>> getAllListOfPlayerClub() {
		List<PlayerClub> list = playerClubService.getAllClubs();
		if(list.isEmpty()){
			return new ResponseEntity<List<PlayerClub>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<PlayerClub>>(list, HttpStatus.OK);
	}

	// -------------------Retrieve All Clubs With player------------------
	@RequestMapping(value = "/enrolled/{playerId}", method = RequestMethod.GET)
	public ResponseEntity<List<PlayerClub>> getAllClubsWithPlayerId(@PathVariable Integer playerId) {
		LOGGER.log(Level.INFO, "Player id: {0}",playerId);
		List<PlayerClub> list = playerClubService.getAllClubsWithPlayerId(playerId);
		if (list.isEmpty()) {
			LOGGER.log(Level.INFO, "Player club list is empty.");
			return new ResponseEntity<List<PlayerClub>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<PlayerClub>>(list, HttpStatus.OK);
	}
	
	// -------------------Associate a Club With player------------------
	@RequestMapping(value = "/enrolled", method = RequestMethod.POST)
	public ResponseEntity<PlayerClub> associatePlayerClubWithLoggedInPlayerId(@RequestBody PlayerClub playerClub) {
		System.out.println("hello post controller");
		System.out.println("in controller of player club " +playerClub);
		playerClubService.enrolPlayerClubWithLoggedInPlayerId(playerClub);
		return new ResponseEntity<PlayerClub>(playerClub, HttpStatus.OK);
	}
	
	// -------------------Dissociate a Club With player------------------
	@RequestMapping(value = "/enrolled/{playerClubId}", method = RequestMethod.DELETE)
	public ResponseEntity<PlayerClub> disassociatePlayerClubWithLoggedInPlayerId(@PathVariable("playerClubId") Integer playerClubId) {
		playerClubService.disassociatePlayerClubWithLoggedInPlayerId(playerClubId);
		return new ResponseEntity<PlayerClub>(HttpStatus.NO_CONTENT);
	}
}