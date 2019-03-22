package com.project.application.badminton.playermaster;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.project.application.exceptions.PlayerMasterAlreadyExistException;
import com.project.application.exceptions.PlayerMasterDoesNotExistWithThePlayerId;
import com.project.application.exceptions.UnmatchingPlayerMasterCredentialsException;
import com.sun.jersey.api.NotFoundException;

@Path("/players")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public class PlayerMasterServiceImplementation implements PlayerMasterService {
	Logger logger = Logger.getLogger(PlayerMasterServiceImplementation.class
			.getName());

	PlayerMasterDaoImplementation dao = new PlayerMasterDaoImplementation();

	/*@GET
	@Path("/")
	@Produces({MediaType.TEXT_PLAIN})
	public Response index() {
	    return Response
	      .status(200)
	      .header("Access-Control-Allow-Origin", "*")
	      .header("Access-Control-Allow-Credentials", "true")
	      .header("Access-Control-Allow-Headers",
	        "Origin, Content-Type, Accept, Authorization")
	      .header("Access-Control-Allow-Methods", 
	        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	      .entity("")
	      .build();
	}*/
	
	@Override
	@GET
	//@Path("secure")
	public List<PlayerMaster> listAllPlayerMasters() {
		return dao.getAllPlayerMasters();
	}

	@Override
	@GET
	@Path("secure/{playerId}")
	public PlayerMaster getPlayerById(@PathParam("playerId") Integer playerId) {
		return dao.getPlayerById(playerId);
	}

	@Override
	@GET
	@Path("secure/number/{mobile}")
	public Response getPlayerMasterByMobileNumber(
			@PathParam("mobile") String playerMobileNumber) {
		PlayerMaster playerMaster = dao
				.getPlayerMasterByMobileNumber(playerMobileNumber);
		if (playerMaster == null) {
			throw new NotFoundException();
		}
		return Response.ok(playerMaster).build();
	}

	@Override
	@GET
	@Path("/authenticate/{playerMobileNumber}/{playerPassword}")
	public PlayerMaster isValidPlayerMaster(
			@PathParam("playerMobileNumber") String playerMobileNumber,
			@PathParam("playerPassword") String playerPassword)
			throws UnmatchingPlayerMasterCredentialsException {
		PlayerMaster master = dao.findPlayerMasterLoginCredentials(
				playerMobileNumber, playerPassword);
		if (master.getPlayerMobileNumber() == null) {
			throw new UnmatchingPlayerMasterCredentialsException(
					"User with given credentials is not found in the database");
		}
		return master;
	}

	@Override
	public boolean isPlayerMasterExists(PlayerMaster playerMaster) {
		return dao.isPlayerMasterExists(playerMaster);
	}

	@Override
	@POST
	//@Path("secure")
	public void addPlayerMaster(PlayerMaster playerMaster)
			throws PlayerMasterAlreadyExistException {

		if (playerMaster == null) {
			throw new WebApplicationException(Response.Status.BAD_REQUEST);
		}
		if (dao.isPlayerMasterExists(playerMaster)) {
			logger.log(Level.INFO, "a player with {0} already exists..",
					playerMaster.getPlayerMobileNumber());
			throw new PlayerMasterAlreadyExistException(
					"Player already exists with the mobile number");
		}
		dao.addPlayerMaster(playerMaster);
	}

	@Override
	@PUT
	@Path("secure/{playerId}")
	public void updatePlayerMaster(@PathParam("playerId") Integer playerId,
			PlayerMaster playerMaster)
			throws PlayerMasterDoesNotExistWithThePlayerId {
		PlayerMaster currentPlayerMaster = dao.getPlayerById(playerId);
		if (currentPlayerMaster == null) {
			try {
				throw new PlayerMasterDoesNotExistWithThePlayerId(
						"Player Id is not valid");
			} catch (Exception e) {
				logger.log(Level.INFO, "Updating a player exception: {0}",
						e.getMessage());
			}
		}
		dao.updatePlayerMaster(playerMaster);
	}

	@Override
	@DELETE
	@Path("secure/{playerId}")
	public Response deletePlayerMaster(Integer playerId) {
		PlayerMaster currentPlayerMaster = dao.getPlayerById(playerId);
		if (currentPlayerMaster == null) {
			return Response.status(Response.Status.NOT_FOUND)
					.entity("Entity not found for: " + playerId).build();
		}
		dao.deletePlayerMaster(playerId);
		return Response.status(Response.Status.OK).build();
	}

}
