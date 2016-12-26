package si.fri.tpo.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import si.fri.tpo.model.Uporabnik;

@Path("/sporocila")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface SporociloREST {
	
	@GET
	@Path("/")
	public Response vrniSporocila(@QueryParam("offset") int offset,@QueryParam("limit") int limit);
	
	@GET
	@Path("/{id}")
	public Response vrniSporocilo(@PathParam("id") int id);
	
	@POST
	@Path("/")
	public Response dodajSporocilo(Uporabnik uporabnik);
	
	@PUT
	@Path("/")
	public Response urediSporocilo(Uporabnik uporabnik);
	
	@DELETE
	@Path("/{id}")
	public Response izbrisiSporocilo(@PathParam("id") int id);
}