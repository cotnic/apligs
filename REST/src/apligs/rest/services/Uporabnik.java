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
			query = conn.prepareStatement("select up_ime, up_priimek, up_email, up_ustvarjen, lo_naziv, vl_naziv "
					+ "from uporabnik up, lokacija lo, vloga vl "
					+ "where up.postna_stevilka = lo.postna_stevilka and up.id_vloga = vl.id_vloga");

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
	public Response returnUserId(@PathParam("id") int id) throws Exception {
		PreparedStatement query = null;
		Connection conn = null;
		String returnString = null;
		Response rsp = null;

		try {
			conn = MySQLApligs.MySQLApligs().getConnection();
			query = conn.prepareStatement("select up_ime, up_priimek, up_email, up_ustvarjen, lo_naziv, vl_naziv "
					+ "from uporabnik up, lokacija lo, vloga vl "
					+ "where up.postna_stevilka = lo.postna_stevilka and up.id_vloga = vl.id_vloga and id_uporabnik = ?");
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

	@GET
	@Path("/genres")
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnUsrGenres(@QueryParam("id") int id) throws Exception {
		PreparedStatement query = null;
		Connection conn = null;
		String returnString = null;
		Response rsp = null;

		try {
			conn = MySQLApligs.MySQLApligs().getConnection();
			query = conn.prepareStatement("select zv.id_zvrst, zv_naziv from zvrst zv, izvaja iz, uporabnik up "
					+ "where zv.id_zvrst = iz.id_zvrst and iz.id_uporabnik = up.id_uporabnik "
					+ "and up.id_uporabnik = ?");
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

	@GET
	@Path("/instruments")
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnUsrInstrument(@QueryParam("id") int id) throws Exception {
		PreparedStatement query = null;
		Connection conn = null;
		String returnString = null;
		Response rsp = null;

		try {
			conn = MySQLApligs.MySQLApligs().getConnection();
			query = conn.prepareStatement("select it.id_instrument, in_naziv from instrument it, igra ig, uporabnik up "
					+ "where it.id_instrument = ig.id_instrument and ig.id_uporabnik = up.id_uporabnik "
					+ "and up.id_uporabnik = ?");
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

	@GET
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnUserLogin(@QueryParam("email") String email, @QueryParam("password") String password)
			throws Exception {
		PreparedStatement query = null;
		Connection conn = null;
		String returnString = null;
		Response rsp = null;

		try {
			conn = MySQLApligs.MySQLApligs().getConnection();
			query = conn.prepareStatement("select * from uporabnik where up_email = ? AND up_geslo = ?");
			query.setString(1, email);
			query.setString(2, password);
			query.setMaxRows(1);

			ResultSet rs = query.executeQuery();

			if (rs.isBeforeFirst()) {
				ToJSON converter = new ToJSON();
				JSONArray json = new JSONArray();

				json = converter.toJSONArray(rs);
				query.close();

				returnString = json.toString();
				rsp = Response.ok(returnString).build();
			} else {
				rsp = Response.ok("false").build();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				conn.close();
		}

		return rsp;
	}

	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUser(@QueryParam("location") int location, @QueryParam("role") int role,
			@QueryParam("name") String name, @QueryParam("surname") String surname, @QueryParam("email") String email,
			@QueryParam("password") String password) throws SQLException {
		PreparedStatement query = null;
		Connection conn = null;
		Response rsp = null;

		try {
			conn = MySQLApligs.MySQLApligs().getConnection();
			query = conn.prepareStatement(
					"insert into uporabnik(postna_stevilka, id_vloga, up_ime, up_priimek, up_email, up_geslo, up_ustvarjen)"
							+ "values (?, ?, ?, ?, ?, ?, CURDATE())");
			query.setInt(1, location);
			query.setInt(2, role);
			query.setString(3, name);
			query.setString(4, surname);
			query.setString(5, email);
			query.setString(6, password);

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
			query = conn.prepareStatement("delete from uporabnik where id_uporabnik = ?");
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

	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editUser(@PathParam("id") int id, @QueryParam("name") String name,
			@QueryParam("surname") String surname, @QueryParam("email") String email) throws SQLException {
		PreparedStatement query = null;
		Connection conn = null;
		Response rsp = null;

		try {
			conn = MySQLApligs.MySQLApligs().getConnection();
			query = conn.prepareStatement("update uporabnik " + "set up_ime = ?, " + "up_priimek = ?, "
					+ "up_email = ? " + "where id_uporabnik = ?");
			query.setString(1, name);
			query.setString(2, surname);
			query.setString(3, email);
			query.setInt(4, id);

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
