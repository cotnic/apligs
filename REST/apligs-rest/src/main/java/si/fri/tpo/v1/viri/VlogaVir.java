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

import si.fri.prpo.zrna.vmesniki.UpravljalecVlogSBLocal;
import si.fri.tpo.model.Vloga;
import si.fri.tpo.rest.VlogaREST;

@Path("/vloge")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class VlogaVir implements VlogaREST {
	@EJB
	UpravljalecVlogSBLocal upravljalecVlog;

	@Override
	@GET
	@Path("/")
	public Response vrniVloge() {
		List<Vloga> vloge = upravljalecVlog.vrniVseVloge();
		return Response.ok(vloge.toArray(new Vloga[vloge.size()])).header("Access-Control-Allow-Origin", "*").build();
	}

	@Override
	@GET
	@Path("/{id}")
	public Response vrniVlogo(@PathParam("id") int id) {
		Vloga vloga = upravljalecVlog.vrniVlogo(id);

		return Response.ok(vloga).header("Access-Control-Allow-Origin", "*").build();
	}

}
