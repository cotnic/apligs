package si.fri.tpo.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import si.fri.tpo.model.Instrument;

@Path("/instrumenti")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface InstrumentREST {

	@GET
	@Path("/")
	public Response vrniInstrumente();
	
	@GET
	@Path("/{id}")
	public Response vrniInstrument(@PathParam("id") int id);
	
	@POST
	@Path("/")
	public Response dodajInstrument(Instrument instrument);
	
	@PUT
	@Path("/")
	public Response urediInstrument(Instrument instrument);
	
	@DELETE
	@Path("/{id}")
	public Response izbrisiInstrument(@PathParam("id") int id);
}
