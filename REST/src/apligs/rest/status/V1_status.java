package apligs.rest.status;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import java.sql.*;

import apligs.dao.*;

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
		return "<p>Version: </p>" + apiVersion;
	}

	@Path("/database")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnDatabaseStatus() throws Exception {

		PreparedStatement query = null;
		String myString = null;
		String returnString = null;
		Connection conn = null;

		try {
			conn = MySQLApligs.MySQLApligs().getConnection();
			query = conn.prepareStatement("select DATE_FORMAT(NOW(),'%d.%m.%Y %H:%i:%s') as date");
			ResultSet rs = query.executeQuery();

			while (rs.next()) {
				myString = rs.getString("date");
			}

			query.close();

			returnString = "<p>Database Status</p> " + "<p>Database Date/Time return: " + myString + "</p>";

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) conn.close();
		}

		return returnString;
	}
}
