package si.fri.tpo.v1.viri;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import si.fri.prpo.zrna.vmesniki.UpravljalecLokacijSBLocal;
import si.fri.tpo.model.Lokacija;
import si.fri.tpo.rest.LokacijaREST;

@Path("/lokacije")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class LokacijaVir implements LokacijaREST {
	@EJB
	UpravljalecLokacijSBLocal upravljalecLokacij;

	@Override
	@GET
	@Path("/")
	public Response vrniLokacije() {
		List<Lokacija> lokacije = upravljalecLokacij.vrniVseLokacije();
		return Response.ok(lokacije.toArray(new Lokacija[lokacije.size()])).header("Access-Control-Allow-Origin", "*").build();
	}

	@Override
	@GET
	@Path("/{id}")
	public Response vrniLokacijo(@PathParam("id") int id) {
		Lokacija lokacija = upravljalecLokacij.vrniLokacijo(id);

		return Response.ok(lokacija).header("Access-Control-Allow-Origin", "*").build();
	}

}
