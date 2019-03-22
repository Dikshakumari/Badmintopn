package com.project.application.badminton.clubmaster;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/clubmasters")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public class ClubMasterServiceImplementation{
	Logger logger = Logger.getLogger(ClubMasterServiceImplementation.class
			.getName());

	ClubMasterDaoImplementation clubMasterDao = new ClubMasterDaoImplementation();

	@GET
	public List<ClubMaster> listAllClubPlayers() {
		return clubMasterDao.getAllClubMasters();
	}
}