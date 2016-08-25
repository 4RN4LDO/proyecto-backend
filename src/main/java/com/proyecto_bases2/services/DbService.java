package com.proyecto_bases2.services;

import com.proyecto_bases2.db_connector.OracleDbConnector;
import com.proyecto_bases2.models.Client;
import com.proyecto_bases2.models.Instrumet;
import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DbService {

  private OracleDbConnector oracleDbConnector;
  private static final String SELECT_ALL_CLIENTS = "SELECT * FROM CLIENTE";

  public static final String SELECT_INSTRUMENTS = "{call proyecto.pck_admin.consInstrumento(?, ?)}";

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

  public String getInstrument(int idInstrument)  {

    String result="nada";
    try {
      CallableStatement stproc_stmt = oracleDbConnector.getOracleConnection().prepareCall(SELECT_INSTRUMENTS);
      stproc_stmt.setInt(1, idInstrument);
      stproc_stmt.registerOutParameter(1, OracleTypes.INTEGER);
      stproc_stmt.registerOutParameter(2, OracleTypes.VARCHAR);
      stproc_stmt.execute();
      result = stproc_stmt.getString(2);
    } catch (SQLException sqlex) {
      sqlex.printStackTrace();

    }

    return result;
  }

  public ArrayList<Instrumet> getAnInstrument() throws SQLException {
    ResultSet selectResult = null;
    Statement statement = null;

    try {
      statement = oracleDbConnector.getOracleConnection().createStatement();
      selectResult = statement.executeQuery(SELECT_INSTRUMENTS);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return createInstrumetList(selectResult);

  }

  public ArrayList<Client> createClientList(ResultSet resultSet) throws SQLException {
    ArrayList<Client> clientList = new ArrayList<>();

    while (resultSet.next()) {
      Client client = serializeClient(resultSet);
      clientList.add(client);
    }

    return clientList;
  }

  public ArrayList<Instrumet> createInstrumetList(ResultSet resultSet) throws SQLException {
    ArrayList<Instrumet> instrumenttList = new ArrayList<>();

    while (resultSet.next()) {
      Instrumet instrumet = serializeInstrument(resultSet);
      instrumenttList.add(instrumet);
    }

    return instrumenttList;
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

  public Instrumet serializeInstrument(ResultSet resultSet) throws SQLException {
    Instrumet instrumet = new Instrumet();

    instrumet.setId(resultSet.getString("id_instrumento"));
    instrumet.setName(resultSet.getString("nombre_instrumento"));

    return instrumet;
  }
}
