package si.fri.tpo.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/lokacije")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface LokacijaREST {

	@GET
	@Path("/")
	public Response vrniLokacije();
	
	@GET
	@Path("/{id}")
	public Response vrniLokacijo(@PathParam("id") int id);
}
