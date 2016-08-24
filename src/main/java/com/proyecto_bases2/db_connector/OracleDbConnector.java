package com.proyecto_bases2.db_connector;

import java.sql.*;

public class OracleDbConnector {

  static Connection dbConn = null;

  public OracleDbConnector() {
    connectToDb();
  }

  public Connection getOracleConnection() {
    return dbConn;
  }

  public void setOracleConnection(Connection dbConnection) {
    this.dbConn = dbConnection;
  }

  public void connectToDb() {
    loadOracleDriver();
    DriverManager.setLoginTimeout(5);
    System.out.println("Oracle JDBC Driver Successfully Registered! Let's make connection now");

    try {
      dbConn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "proyecto", "root");
    } catch (SQLException e) {
      System.out.println("Connection Failed! Check output console");
      e.printStackTrace();
    }
  }


  public void loadOracleDriver(){
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
    } catch (ClassNotFoundException exception) {
      System.out.println("Oracle Driver Class Not found Exception: " + exception.toString());
    }
  }
}
