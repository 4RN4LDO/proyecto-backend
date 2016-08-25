package com.proyecto_bases2.ws;

import com.google.gson.Gson;
import com.proyecto_bases2.models.Client;
import com.proyecto_bases2.models.Instrumet;
import com.proyecto_bases2.services.DbService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.Console;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("v2/instrument/{id}")
public class InstrumetResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String getInstrumet(@PathParam("id") int idInstrument) {
    ArrayList<Instrumet> instrumetList;
    String instrumetsJson;

    DbService dbService = new DbService();
    String instrumentName = dbService.getInstrument(idInstrument);

    System.out.print(String.format("{ name: '%s'}", instrumentName));

    //instrumetsJson = new Gson().toJson(instrumetList);
    //return String.format("{name:\"%s\"}", instrumentName);
  return new Gson().toJson(instrumentName);

  }

}
