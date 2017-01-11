package si.fri.tpo.v1.viri;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import si.fri.prpo.zrna.vmesniki.UpravljalecSporocilSBLocal;
import si.fri.tpo.model.Sporocilo;
import si.fri.tpo.rest.SporociloREST;

@Path("/sporocila")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class SporociloVir implements SporociloREST{
	@EJB 
	UpravljalecSporocilSBLocal upravljalecSporocil;

	@Override
	@GET
	@Path("/")
	public Response vrniSporocila(@QueryParam("offset") int offset, @QueryParam("limit") int limit) {
		if (limit > 0) {
			List<Sporocilo> sporocila = upravljalecSporocil.vrniVsaSporocila(offset, limit);
			return Response.ok(sporocila.toArray(new Sporocilo[sporocila.size()])).header("Access-Control-Allow-Origin", "*").build();
		}
		List<Sporocilo> sporocila = upravljalecSporocil.vrniVsaSporocila();
		return Response.ok(sporocila.toArray(new Sporocilo[sporocila.size()])).header("Access-Control-Allow-Origin", "*").build();
	}

	@Override
	@GET
	@Path("/{id}")
	public Response vrniSporocilo(@PathParam("id") int id) {
		Sporocilo sporocilo = upravljalecSporocil.vrniSporocilo(id);
		
		return Response.ok(sporocilo).header("Access-Control-Allow-Origin", "*").build();
	}
	
	@Override
	@GET
	@Path("/poslano/{id}")
	public Response vrniPoslano(@PathParam("id") int id) {
		List<Sporocilo> sporocila = upravljalecSporocil.vrniPoslano(id);
		
		return Response.ok(sporocila.toArray(new Sporocilo[sporocila.size()])).header("Access-Control-Allow-Origin", "*").build();
	}
	
	@Override
	@GET
	@Path("/prejeto/{id}")
	public Response vrniPrejeto(@PathParam("id") int id) {
		List<Sporocilo> sporocila = upravljalecSporocil.vrniPrejeto(id);
		
		return Response.ok(sporocila.toArray(new Sporocilo[sporocila.size()])).header("Access-Control-Allow-Origin", "*").build();
	}

	@Override
	@POST
	@Path("/")
	public Response dodajSporocilo(Sporocilo sporocilo) {
		upravljalecSporocil.shraniSporocilo(sporocilo);

		return Response.ok("ok").header("Access-Control-Allow-Origin", "*").build();
	}

	@Override
	@PUT
	public Response urediSporocilo(Sporocilo sporocilo) {
		upravljalecSporocil.posodobiSporocilo(sporocilo);
		
		return Response.ok("ok").header("Access-Control-Allow-Origin", "*").build();
	}

	@Override
	@DELETE
	@Path("/{id}")
	public Response izbrisiSporocilo(@PathParam("id") int id) {
		upravljalecSporocil.zbrisiSporocilo(id);

		return Response.ok("ok").header("Access-Control-Allow-Origin", "*").build();
	}

	@Override
	@OPTIONS
	@Path("/")
	public Response optionResponse1() {
		return Response.ok("ok").header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE").header("Access-Control-Allow-Headers", "Content-Type").build();
	}
	
	@Override
	@OPTIONS
	@Path("/{id}")
	public Response optionResponse2() {
		return Response.ok("ok").header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE").header("Access-Control-Allow-Headers", "Content-Type").build();
	}
}
