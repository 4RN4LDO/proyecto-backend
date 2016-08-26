package com.proyecto_bases2.ws.utils;

import com.google.gson.Gson;
import com.proyecto_bases2.models.ClientEvent;
import com.proyecto_bases2.models.User;
import com.proyecto_bases2.services.DbService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("v1/client_events/{clientId}")
public class ClientEventResource {
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String getClientEvents(@PathParam("clientId") int clientId, @QueryParam("username") String username, @QueryParam("password") String password) {

    // JsonObject response = new JsonObject();
    User user = new User(username, password);
    DbService dbService = new DbService(user);

    ClientEvent clientEvent = dbService.getClientEvent(String.valueOf(clientId));
    return new Gson().toJson(clientEvent);
  }
}
