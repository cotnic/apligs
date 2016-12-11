package apligs.rest.services;

import java.sql.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;

import apligs.dao.MySQLApligs;
import apligs.util.ToJSON;

@Path("/v1/adverts")
public class Oglas {

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnAllAds() throws Exception {
		PreparedStatement query = null;
		Connection conn = null;
		String returnString = null;
		Response rsp = null;

		try {
			conn = MySQLApligs.MySQLApligs().getConnection();
			query = conn
					.prepareStatement("select id_oglas, og_naslov, up_email, zv_naziv, vl_naziv, og_opis, og_objavljen "
							+ "from oglas og, zvrst zv, uporabnik up, vloga vl "
							+ "where og.id_uporabnik = up.id_uporabnik and vl.id_vloga = og.id_vloga and zv.id_zvrst = og.id_zvrst "
							+ "order by og_objavljen");

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

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnAddById(@PathParam("id") int id) throws Exception {
		PreparedStatement query = null;
		Connection conn = null;
		String returnString = null;
		Response rsp = null;

		try {
			conn = MySQLApligs.MySQLApligs().getConnection();
			query = conn.prepareStatement("select og_naslov, up_email, zv_naziv, vl_naziv, og_opis, og_objavljen "
					+ "from oglas og, zvrst zv, uporabnik up, vloga vl "
					+ "where og.id_uporabnik = up.id_uporabnik and vl.id_vloga = og.id_vloga and zv.id_zvrst = og.id_zvrst "
					+ "and id_oglas = ?");
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
	public Response createUser(@PathParam("id") int usrId, @QueryParam("role") int role,
			@QueryParam("name") int genreId, @QueryParam("title") String title, @QueryParam("desc") String desc) throws SQLException {
		PreparedStatement query = null;
		Connection conn = null;
		Response rsp = null;

		try {
			conn = MySQLApligs.MySQLApligs().getConnection();
			query = conn.prepareStatement(
					"insert into oglas(id_vloga, id_uporabnik, id_zvrst, og_naslov, og_objavljen, og_opis, og_premium) "
							+ "values(?, ?, ?, ?, CURDATE(), ?, false)");
			query.setInt(1, role);
			query.setInt(2, usrId);
			query.setInt(3, genreId);
			query.setString(4, title);
			query.setString(5, desc);

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
			query = conn.prepareStatement("delete from oglas where id_oglas = ?");
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
