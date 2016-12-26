package si.fri.tpo.v1.viri;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import si.fri.prpo.zrna.vmesniki.UpravljalecOglasovSBLocal;
import si.fri.tpo.model.Ogla;
import si.fri.tpo.model.Uporabnik;
import si.fri.tpo.rest.OglasREST;

@Path("/oglasi")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class OglasVir implements OglasREST{
	@EJB
	UpravljalecOglasovSBLocal upravljalecOglasov;

	@Override
	@GET
	public Response vrniOglase(@QueryParam("offset") int offset, @QueryParam("limit") int limit) {
		if (limit > 0) {
			List<Ogla> uporabniki = upravljalecOglasov.vrniVseOglase(offset, limit);
			return Response.ok(uporabniki.toArray(new Ogla[uporabniki.size()])).build();
		}
		List<Ogla> oglasi = upravljalecOglasov.vrniVseOglase();
		return Response.ok(oglasi.toArray(new Ogla[oglasi.size()])).build();
	}

	@Override
	@GET
	@Path("/{id}")
	public Response vrniOglas(@PathParam("id") int id) {
		Ogla oglas = upravljalecOglasov.vrniOglas(id);
		
		return Response.ok(oglas).build();
	}

	@Override
	public Response dodajOglas(Ogla oglas) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response urediOglas(Ogla oglas) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response izbrisiOglas(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
