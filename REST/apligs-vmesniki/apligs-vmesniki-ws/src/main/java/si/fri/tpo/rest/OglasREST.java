package si.fri.tpo.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import si.fri.tpo.model.Ogla;

@Path("/oglasi")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface OglasREST {
	
	@GET
	@Path("/")
	public Response vrniOglase(@QueryParam("offset") int offset,@QueryParam("limit") int limit);
	
	@GET
	@Path("/{id}")
	public Response vrniOglas(@PathParam("id") int id);
	
	@POST
	@Path("/")
	public Response dodajOglas(Ogla oglas);
	
	@PUT
	@Path("/")
	public Response urediOglas(Ogla oglas);
	
	@DELETE
	@Path("/{id}")
	public Response izbrisiOglas(@PathParam("id") int id);

	@OPTIONS
	@Path("/")
	public Response optionResponse1();
	
	@OPTIONS
	@Path("/{id}")
	public Response optionResponse2();
}