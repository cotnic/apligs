package apligs.rest.services;

import java.sql.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;

import apligs.dao.MySQLApligs;
import apligs.util.ToJSON;

@Path("/v1/messages")
public class Sporocilo {

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnAllMessages(@PathParam("id") int id) throws Exception {
		PreparedStatement query = null;
		Connection conn = null;
		String returnString = null;
		Response rsp = null;

		try {
			conn = MySQLApligs.MySQLApligs().getConnection();
			query = conn.prepareStatement(
					"SELECT (select up_email from uporabnik where id_uporabnik = id_poslje) as posiljatelj, "
							+ "(select up_email from uporabnik where id_uporabnik = id_prejme) as prejemnik, "
							+ "sp_zadeva, sp_vsebina, sp_poslano FROM sporocilo where id_poslje = ?");
			query.setInt(1, id);

			ResultSet rs = query.executeQuery();

			ToJSON converter = new ToJSON();
			JSONArray json = new JSONArray();

			json = converter.toJSONArray(rs);
			query.close();

			returnString = json.toString();
			rsp = Response.ok(returnString).build();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				conn.close();
		}

		return rsp;
	}

	@POST
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUser(@PathParam("id") int idSend, @QueryParam("id") int idRecv,
			@QueryParam("title") String title, @QueryParam("msg") String msg) throws SQLException {
		PreparedStatement query = null;
		Connection conn = null;
		Response rsp = null;

		try {
			conn = MySQLApligs.MySQLApligs().getConnection();
			query = conn
					.prepareStatement("insert into sporocilo(id_poslje, id_prejme, sp_zadeva, sp_vsebina, sp_poslano) "
							+ "values(?, ?, ?, ?, CURDATE());");
			query.setInt(1, idSend);
			query.setInt(2, idRecv);
			query.setString(3, title);
			query.setString(4, msg);

			if (query.executeUpdate() == 1)
				rsp = Response.ok("true").build();
			else
				rsp = Response.ok("false").build();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				conn.close();
		}

		return rsp;
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteUser(@PathParam("id") int id) throws SQLException {
		PreparedStatement query = null;
		Connection conn = null;
		Response rsp = null;

		try {
			conn = MySQLApligs.MySQLApligs().getConnection();
			query = conn.prepareStatement("delete from sporocilo where id_sporocila = ?");
			query.setInt(1, id);

			if (query.executeUpdate() == 1)
				rsp = Response.ok("true").build();
			else
				rsp = Response.ok("false").build();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				conn.close();
		}

		return rsp;
	}
}
