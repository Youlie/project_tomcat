package com.aplose.smooss.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.aplose.smooss.model.User;
import com.aplose.smooss.services.UserService;
//import com.aplose.smooss.services.UserService;

@Path("users")
public class UserREST {

	// Method qui retour un utilisateur à partir de l'id
	// et qu'il l'affiche.
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User readUser(@PathParam("id") long id) {
		User u = UserService.getInstance().read(id);
		if (u == null) {
			u = new User();
		}
		return new User();
	}

	// faire une méthode list
	// public List<User> getUsers() {
	// return UserService.getInstance();
	// }
}
