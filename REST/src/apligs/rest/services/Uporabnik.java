package apligs.rest.services;

import java.sql.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;

import apligs.dao.MySQLApligs;
import apligs.util.ToJSON;

@Path("/v1/users")
public class Uporabnik {
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnAllUsers() throws Exception {
		PreparedStatement query = null;
		Connection conn = null;
		String returnString = null;
		Response rsp = null;
		
		try {
			conn = MySQLApligs.MySQLApligs().getConnection();
			query = conn.prepareStatement("select * from uporabnik");
			
			ResultSet rs = query.executeQuery();

			ToJSON converter = new ToJSON();
			JSONArray json = new JSONArray();
			
			json = converter.toJSONArray(rs);
			query.close();
			
			returnString = json.toString();
			rsp = Response.ok(returnString).build();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) conn.close();
		}
		
		return rsp;
	}

	
}
