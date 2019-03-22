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

import com.iris.badminton.model.persistance.bean.PlayerMaster;
import com.iris.badminton.model.service.dao.PlayerMasterService;

@RestController
@RequestMapping(headers = "Accept=application/json")
public class PlayerMasterController {
	private static final Logger LOGGER = Logger.getLogger(PlayerMasterController.class.getName());
	private PlayerMasterService playerMasterService;

	public PlayerMasterController() {
	}

	@Autowired
	public PlayerMasterController(PlayerMasterService playerMasterService) {
		this.playerMasterService = playerMasterService;
	}

	// -------------------Retrieve All Players--------------------------------
	@RequestMapping(value = "/players", method = RequestMethod.GET)
	public ResponseEntity<List<PlayerMaster>> listAllPlayerMasters() {
		List<PlayerMaster> list = playerMasterService.listAllPlayerMasters();
		if (list.isEmpty()) {
			LOGGER.log(Level.INFO, "List is empty.");
			return new ResponseEntity<List<PlayerMaster>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<PlayerMaster>>(list, HttpStatus.OK);
	}

	// -------------------Retrieve Single Player------------------------------
	@RequestMapping(value = "/players/{playerId}", method = RequestMethod.GET)
	public ResponseEntity<PlayerMaster> getPlayerById(@PathVariable Integer playerId) {
		PlayerMaster master = playerMasterService.getPlayerById(playerId);
		if (master == null) {
			return new ResponseEntity<PlayerMaster>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<PlayerMaster>(master, HttpStatus.OK);
	}

	// ------------------Retrieve Single Player Using Mobile------------------
	@RequestMapping(value = "/players/getmobile/{playerMobileNumber}", method = RequestMethod.GET)
	public ResponseEntity<PlayerMaster> getPlayerMasterByMobileNumber(@PathVariable String playerMobileNumber) {
		PlayerMaster master = playerMasterService.getPlayerMasterByMobileNumber(playerMobileNumber);
		if (master == null) {
			return new ResponseEntity<PlayerMaster>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<PlayerMaster>(master, HttpStatus.OK);
	}

	// -------------------Verify Player Credentials---------------------------
	@RequestMapping(value = "/players/verify/{mobileNumber}/{password}", method = RequestMethod.GET)
	public ResponseEntity<PlayerMaster> verifyLoginCredentials(@PathVariable String mobileNumber, @PathVariable String password) {
		PlayerMaster master = playerMasterService.verifyLoginCredentials(mobileNumber, password);
		if (master == null) {
			return new ResponseEntity<PlayerMaster>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<PlayerMaster>(master, HttpStatus.OK);
	}

	// -------------------Create a Player-------------------------------------
	@RequestMapping(value = "/players", method = RequestMethod.POST)
	public ResponseEntity<PlayerMaster> addPlayerMaster(@RequestBody PlayerMaster master) {
		if (playerMasterService.isPlayerMasterExists(master)) {
			LOGGER.log(Level.INFO, "is player exists: {0}", playerMasterService.isPlayerMasterExists(master));
			return new ResponseEntity<PlayerMaster>(HttpStatus.CONFLICT);
		}
		playerMasterService.addPlayerMaster(master);
		master.getPlayerId();
		LOGGER.log(Level.INFO, "generated ID: {0}", master.getPlayerId());
		return new ResponseEntity<PlayerMaster>(master, HttpStatus.OK);
	}

	// -------------------Update a Player-------------------------------------
	@RequestMapping(value = "/players/{playerId}", method = RequestMethod.PUT)
	public ResponseEntity<PlayerMaster> updatePlayerMaster(@PathVariable Integer playerId, @RequestBody PlayerMaster master) {
		PlayerMaster currentPlayer = playerMasterService.getPlayerById(playerId);
		if (currentPlayer == null) {
			return new ResponseEntity<PlayerMaster>(HttpStatus.NOT_FOUND);
		}
		playerMasterService.updatePlayerMaster(master);
		return new ResponseEntity<PlayerMaster>(master, HttpStatus.OK);
	}

	// -------------------Delete a Player-------------------------------------
	@RequestMapping(value = "/players/{playerId}", method = RequestMethod.DELETE)
	public ResponseEntity<PlayerMaster> deletePlayerMaster(@PathVariable Integer playerId) {
		PlayerMaster currentPlayer = playerMasterService.getPlayerById(playerId);
		if (currentPlayer == null) {
			return new ResponseEntity<PlayerMaster>(HttpStatus.NOT_FOUND);
		}
		playerMasterService.deletePlayerMaster(playerId);
		return new ResponseEntity<PlayerMaster>(HttpStatus.NO_CONTENT);
	}

	// -------------------is Player Exist-------------------------------------
	public boolean isPlayerMasterExists(PlayerMaster playerMaster) {
		return playerMasterService.isPlayerMasterExists(playerMaster);
	}

}