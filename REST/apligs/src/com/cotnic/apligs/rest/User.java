package com.cotnic.apligs.rest;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@Path("/users/")
public class User {

	@GET
	@Produces("text/plain")
	@Path("/user")
	public String geUser() {
		return "Hello APLIGS!";
	}

}
