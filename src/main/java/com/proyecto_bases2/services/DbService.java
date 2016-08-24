package com.proyecto_bases2.services;

import com.proyecto_bases2.db_connector.OracleDbConnector;
import com.proyecto_bases2.models.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DbService {

  private OracleDbConnector oracleDbConnector;
  private static final String SELECT_ALL_CLIENTS = "SELECT * FROM CLIENTE";

  public DbService(OracleDbConnector dbConnector) {
    oracleDbConnector = dbConnector;
  }

  public DbService() {
    this.oracleDbConnector = new OracleDbConnector();
  }

  public ArrayList<Client> getAllClients() throws SQLException {
    ResultSet selectResult = null;
    Statement statement = null;

    try {
      statement = oracleDbConnector.getOracleConnection().createStatement();
      selectResult = statement.executeQuery(SELECT_ALL_CLIENTS);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return createClientList(selectResult);
  }

  public ArrayList<Client> createClientList(ResultSet resultSet) throws SQLException {
    ArrayList<Client> clientList = new ArrayList<>();

    while (resultSet.next()) {
      Client client = serializeClient(resultSet);
      clientList.add(client);
    }

    return clientList;
  }

  public Client serializeClient(ResultSet resultSet) throws SQLException {
    Client client = new Client();

    client.setId(resultSet.getString("cedula_cliente"));
    client.setName(resultSet.getString("nombre_cliente"));
    client.setFirstLastName(resultSet.getString("apellidoc1"));
    client.setSecondLastName(resultSet.getString("apellidoc2"));
    client.setPhone(resultSet.getString("telefono"));
    client.setEmail(resultSet.getString("email"));
    client.setStatus(resultSet.getString("estado"));

    return client;
  }
}
