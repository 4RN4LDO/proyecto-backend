package com.proyecto_bases2.ws;

import com.google.gson.Gson;
import com.proyecto_bases2.models.Client;
import com.proyecto_bases2.services.DbService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("v1/client")
public class ClientResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getClients() throws SQLException {
      ArrayList<Client> clientList;
      String clientsJson;

      DbService dbService = new DbService();
      clientList = dbService.getAllClients();
      clientsJson = new Gson().toJson(clientList);
      return clientsJson;
    }


}
