package si.fri.tpo.v1.viri;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import si.fri.prpo.zrna.vmesniki.UpravljalecUporabnikovSBLocal;
import si.fri.tpo.model.Uporabnik;
import si.fri.tpo.rest.UporabnikREST;

@Path("/uporabniki")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class UporabnikVir implements UporabnikREST {
	@EJB
	UpravljalecUporabnikovSBLocal upravljalecUporabnikov;

	@Override
	@GET
	public Response vrniUporabnike(@QueryParam("offset") int offset, @QueryParam("limit") int limit) {
		if (limit > 0) {
			List<Uporabnik> uporabniki = upravljalecUporabnikov.vrniVseUporabnike(offset, limit);
			return Response.ok(uporabniki.toArray(new Uporabnik[uporabniki.size()])).header("Access-Control-Allow-Origin", "*").build();
		}
		List<Uporabnik> uporabniki = upravljalecUporabnikov.vrniVseUporabnike();
		return Response.ok(uporabniki.toArray(new Uporabnik[uporabniki.size()])).header("Access-Control-Allow-Origin", "*").build();
	}

	@Override
	@GET
	@Path("/{id}")
	public Response vrniUporabnika(@PathParam("id") int id) {
		Uporabnik uporabnik = upravljalecUporabnikov.vrniUporabnika(id);

		return Response.ok(uporabnik).header("Access-Control-Allow-Origin", "*").build();
	}

	@Override
	@POST
	@Path("/")
	public Response dodajUporabnika(Uporabnik uporabnik) {
		upravljalecUporabnikov.shraniUporabnika(uporabnik);

		return Response.ok("ok").header("Access-Control-Allow-Origin", "*").build();
	}

	@Override
	@PUT
	@Path("/")
	public Response urediUporabnika(Uporabnik uporabnik) {
		upravljalecUporabnikov.posodobiUporabnika(uporabnik);

		return Response.ok("ok").header("Access-Control-Allow-Origin", "*").build();
	}

	@Override
	@DELETE
	@Path("/{id}")
	public Response izbrisiUporabnika(@PathParam("id") int id) {
		upravljalecUporabnikov.zbrisiUporabnika(id);

		return Response.ok("ok").header("Access-Control-Allow-Origin", "*").build();
	}

	@Override
	@GET
	@Path("/prijava")
	public Response vrniUporabnike(@QueryParam("email") String email, @QueryParam("password") String password) {
		Uporabnik uporabnik = upravljalecUporabnikov.prijaviUporabnika(email, password);
		if (uporabnik != null)
			return Response.ok(uporabnik).header("Access-Control-Allow-Origin", "*").build();
		else
			return Response.status(204).header("Access-Control-Allow-Origin", "*").build();
	}

}
