package si.fri.tpo.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/vloge")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface VlogaREST {

	@GET
	@Path("/")
	public Response vrniVloge();
	
	@GET
	@Path("/{id}")
	public Response vrniVlogo(@PathParam("id") int id);
}
