package com.project.application.badminton.clubplayers;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/clubplayers")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public class ClubPlayersServiceImplementation implements ClubPlayersService {

	Logger logger = Logger.getLogger(ClubPlayersServiceImplementation.class
			.getName());

	ClubPlayersDaoImplementation clubPlayersDao = new ClubPlayersDaoImplementation();

	@Override
	@GET
	public List<ClubPlayers> listAllClubPlayers() {
		return clubPlayersDao.getAllClubPlayers();
	}

	@Override
	@GET
	@Path("{clubPlayerPlayerId}")
	public List<ClubPlayers> getClubPlayersByPlayerId(@PathParam("clubPlayerPlayerId") Integer clubPlayerPlayerId) {
		return clubPlayersDao.getClubPlayerByClubPlayerPlayerId(clubPlayerPlayerId);
	}
	
	/*@Override
	@GET
	@Path("{clubPlayerPlayerId}")
	public Response getClubPlayerByPlayerId(@PathParam("clubPlayerPlayerId") Integer clubPlayerPlayerId) {
		ClubPlayers clubPlayers = clubPlayersDao
				.getClubPlayerByPlayerId(clubPlayerPlayerId);
		if (clubPlayers.getClubPlayerId() == 0) {
			return Response.serverError().build();
		}
		return Response.ok(clubPlayers).build();
	}*/

}