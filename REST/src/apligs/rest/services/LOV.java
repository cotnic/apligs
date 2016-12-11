package apligs.rest.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;

import apligs.dao.MySQLApligs;
import apligs.util.ToJSON;

/**
 * List of Values
 * @author mkotnik
 *
 */
@Path("/v1/lov")
public class LOV {

	@GET
	@Path("/locations")
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnLocations() throws Exception {
		PreparedStatement query = null;
		Connection conn = null;
		String returnString = null;
		Response rsp = null;

		try {
			conn = MySQLApligs.MySQLApligs().getConnection();
			query = conn.prepareStatement(
					"select * from lokacija");

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
	public Response returnInstruments() throws Exception {
		PreparedStatement query = null;
		Connection conn = null;
		String returnString = null;
		Response rsp = null;

		try {
			conn = MySQLApligs.MySQLApligs().getConnection();
			query = conn.prepareStatement(
					"select * from instrument");

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
	@Path("/roles")
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnRoles() throws Exception {
		PreparedStatement query = null;
		Connection conn = null;
		String returnString = null;
		Response rsp = null;

		try {
			conn = MySQLApligs.MySQLApligs().getConnection();
			query = conn.prepareStatement(
					"select * from vloga");

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
	public Response returnGenre() throws Exception {
		PreparedStatement query = null;
		Connection conn = null;
		String returnString = null;
		Response rsp = null;

		try {
			conn = MySQLApligs.MySQLApligs().getConnection();
			query = conn.prepareStatement(
					"select * from zvrst");

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
}