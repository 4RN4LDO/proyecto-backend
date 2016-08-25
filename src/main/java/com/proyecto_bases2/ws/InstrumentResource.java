package com.proyecto_bases2.ws;

import com.google.gson.Gson;
import com.proyecto_bases2.models.User;
import com.proyecto_bases2.services.DbService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("v2/instrument/{id}")
public class InstrumentResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String getInstrumet(@PathParam("id") int idInstrument, @QueryParam("username") String username,
                             @QueryParam("password") String password) {
    User user = new User(username, password);
    DbService dbService = new DbService(user);
    String instrumentName = dbService.getInstrument(idInstrument);
    System.out.print(String.format("{ name: '%s'}", instrumentName));
    return new Gson().toJson(instrumentName);
  }

}
