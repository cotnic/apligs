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
	public Response vrniSporocila(@QueryParam("offset") int offset, @QueryParam("limit") int limit) {
		if (limit > 0) {
			List<Sporocilo> sporocila = upravljalecSporocil.vrniVsaSporocila(offset, limit);
			return Response.ok(sporocila.toArray(new Sporocilo[sporocila.size()])).build();
		}
		List<Sporocilo> sporocila = upravljalecSporocil.vrniVsaSporocila();
		return Response.ok(sporocila.toArray(new Sporocilo[sporocila.size()])).build();
	}

	@Override
	@GET
	@Path("/{id}")
	public Response vrniSporocilo(@PathParam("id") int id) {
		Sporocilo sporocilo = upravljalecSporocil.vrniSporocilo(id);
		
		return Response.ok(sporocilo).build();
	}
	
	@Override
	@GET
	@Path("/poslano/{id}")
	public Response vrniPoslano(@PathParam("id") int id) {
		List<Sporocilo> sporocila = upravljalecSporocil.vrniPoslano(id);
		
		return Response.ok(sporocila.toArray(new Sporocilo[sporocila.size()])).build();
	}
	
	@Override
	@GET
	@Path("/prejeto/{id}")
	public Response vrniPrejeto(@PathParam("id") int id) {
		List<Sporocilo> sporocila = upravljalecSporocil.vrniPrejeto(id);
		
		return Response.ok(sporocila.toArray(new Sporocilo[sporocila.size()])).build();
	}

	@Override
	@POST
	public Response dodajSporocilo(Sporocilo Sporocilo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PUT
	public Response urediSporocilo(Sporocilo sporocilo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@DELETE
	public Response izbrisiSporocilo(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
