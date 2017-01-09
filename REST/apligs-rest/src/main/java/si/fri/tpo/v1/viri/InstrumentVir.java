package si.fri.tpo.v1.viri;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import si.fri.prpo.zrna.vmesniki.UpravljalecInstrumentovSBLocal;
import si.fri.tpo.model.Instrument;
import si.fri.tpo.rest.InstrumentREST;

@Path("/instrumenti")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class InstrumentVir implements InstrumentREST {

	@EJB
	UpravljalecInstrumentovSBLocal upravljalecInstrumentov;

	@Override
	@GET
	@Path("/")
	public Response vrniInstrumente() {
		List<Instrument> instrumenti = upravljalecInstrumentov.vrniVseInstrumente();
		return Response.ok(instrumenti.toArray(new Instrument[instrumenti.size()])).header("Access-Control-Allow-Origin", "*").build();
	}

	@Override
	@GET
	@Path("/{id}")
	public Response vrniInstrument(int id) {
		Instrument instrument = upravljalecInstrumentov.vrniInstrument(id);

		return Response.ok(instrument).header("Access-Control-Allow-Origin", "*").build();
	}

	@Override
	public Response dodajInstrument(Instrument instrument) {
		upravljalecInstrumentov.shraniInstrument(instrument);

		return Response.ok("ok").header("Access-Control-Allow-Origin", "*").build();
	}

	@Override
	public Response urediInstrument(Instrument instrument) {
		upravljalecInstrumentov.posodobiInstrument(instrument);
		
		return Response.ok("ok").header("Access-Control-Allow-Origin", "*").build();
	}

	@Override
	public Response izbrisiInstrument(int id) {
		upravljalecInstrumentov.zbrisiInstrument(id);
		
		return Response.ok("ok").header("Access-Control-Allow-Origin", "*").build();
	}

}
