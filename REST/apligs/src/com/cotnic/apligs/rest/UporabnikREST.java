package com.cotnic.apligs.rest;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import java.sql.Date;
import java.util.Calendar;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import com.cotnic.apligs.entities.Uporabnik;

@Path("/users/")
public class UporabnikREST {

	@GET
	@Produces("application/json")
	@Path("{uporabnikId}")
	public Uporabnik getUporabnik(@PathParam("uporabnikId") int id) {
		Uporabnik uporabnik = new Uporabnik(id, 2380, 1, "Mitja", "Kotnik", "mj0073@student.uni-lj.si",
				new Date(Calendar.getInstance().getTime().getTime()));
		return uporabnik;
	}
}
