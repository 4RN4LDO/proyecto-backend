package com.proyecto_bases2.ws;

import com.google.gson.Gson;
import com.proyecto_bases2.models.Evento;
import com.proyecto_bases2.models.User;
import com.proyecto_bases2.services.DbService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("v1/events/{presenterId}")
public class EventResourceByPresenter {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String getEvents(@PathParam("presenterId") int presenterId, @QueryParam("username") String username, @QueryParam("password") String password) {

   // JsonObject response = new JsonObject();
    User user = new User(username, password);
    DbService dbService = new DbService(user);

    Evento event = dbService.getEvent(String.valueOf(presenterId));
    return new Gson().toJson(event);
  }
}
