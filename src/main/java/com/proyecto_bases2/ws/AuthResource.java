package com.proyecto_bases2.ws;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.proyecto_bases2.models.User;
import com.proyecto_bases2.services.DbService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("v1/auth")
public class AuthResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String auth(@QueryParam("username") String username, @QueryParam("password") String password) {
    JsonObject response = new JsonObject();
    User user = new User(username, password);
    DbService dbService = new DbService(user);
    response.addProperty("status", Boolean.toString(dbService.userExists(user)));

    return response.toString();
  }
}
