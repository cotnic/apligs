package apligs.rest.status;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path(("/v1/status"))
public class V1_status {
	private static String apiVersion = "1.0.1";

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle() {
		return "<p>Java Web Service</p>";
	}
	
	@Path("/version")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnVersion() {
		return apiVersion;
	}
}
