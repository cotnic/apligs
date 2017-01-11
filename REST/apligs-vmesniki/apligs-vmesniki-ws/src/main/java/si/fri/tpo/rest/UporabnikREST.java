package si.fri.tpo.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import si.fri.tpo.model.Uporabnik;

@Path("/uporabniki")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface UporabnikREST {
	
	@GET
	@Path("/")
	public Response vrniUporabnike(@QueryParam("offset") int offset,@QueryParam("limit") int limit);

	@GET
	@Path("/")
	public Response vrniUporabnike(@QueryParam("email") String email, @QueryParam("password") String password);
	
	@GET
	@Path("/{id}")
	public Response vrniUporabnika(@PathParam("id") int id);
	
	@POST
	@Path("/")
	public Response dodajUporabnika(Uporabnik uporabnik);
	
	@PUT
	@Path("/")
	public Response urediUporabnika(Uporabnik uporabnik);
	
	@DELETE
	@Path("/{id}")
	public Response izbrisiUporabnika(@PathParam("id") int id);

	@OPTIONS
	@Path("/")
	public Response optionResponse1();
	
	@OPTIONS
	@Path("/{id}")
	public Response optionResponse2();
}