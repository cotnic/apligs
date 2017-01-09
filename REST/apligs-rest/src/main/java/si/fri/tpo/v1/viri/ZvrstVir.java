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

import si.fri.prpo.zrna.vmesniki.UpravljalecZvrstiSBLocal;
import si.fri.tpo.model.Zvrst;
import si.fri.tpo.rest.ZvrstREST;

@Path("/zvrsti")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class ZvrstVir implements ZvrstREST {
	@EJB
	UpravljalecZvrstiSBLocal upravljalecZvrsti;

	@Override
	@GET
	@Path("/")
	public Response vrniZvrsti() {
		List<Zvrst> zvrsti = upravljalecZvrsti.vrniVseZvrsti();
		return Response.ok(zvrsti.toArray(new Zvrst[zvrsti.size()])).header("Access-Control-Allow-Origin", "*").build();
	}

	@Override
	@GET
	@Path("/{id}")
	public Response vrniZvrst(@PathParam("id") int id) {
		Zvrst zvrst = upravljalecZvrsti.vrniZvrst(id);

		return Response.ok(zvrst).header("Access-Control-Allow-Origin", "*").build();
	}
}
