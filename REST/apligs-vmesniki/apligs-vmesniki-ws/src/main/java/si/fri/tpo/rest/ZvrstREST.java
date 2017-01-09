package si.fri.tpo.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/zvrsti")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ZvrstREST {

	@GET
	@Path("/")
	public Response vrniZvrsti();
	
	@GET
	@Path("/{id}")
	public Response vrniZvrst(@PathParam("id") int id);
}
