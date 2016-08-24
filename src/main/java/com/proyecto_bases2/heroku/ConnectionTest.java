package com.proyecto_bases2.heroku;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Arnaldo on 23/08/2016.
 */
public class ConnectionTest {
    static Connection crunchifyConn = null;
    static Statement crunchifyStmt = null;
    static ResultSet crunchifyResultset = null;

    public static void main(String[] args) throws SQLException {
        System.out.println("-------- Connection test  ------");

        try {
            // Returns the Class object associated with the class
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException exception) {
            System.out.println("Oracle Driver Class Not found Exception: " + exception.toString());
            return;
        }

        // Set connection timeout. Make sure you set this correctly as per your need
        DriverManager.setLoginTimeout(5);
        System.out.println("Oracle JDBC Driver Successfully Registered! Let's make connection now");

        try {
            // Attempts to establish a connection
            // here DB name: localhost, sid: orcl        jdbc:oracle:thin:@localhost:1521:orcl
            crunchifyConn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "proyecto", "root");
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }

        // Creates a Statement object for sending SQL statements to the database
        crunchifyStmt = crunchifyConn.createStatement();

        // Executes the given SQL statement, which returns a single ResultSet object
        crunchifyResultset = crunchifyStmt.executeQuery("SELECT * from GENERO where id_genero = 102");

        if (crunchifyResultset.next()) {
            System.out.println("Genero Details: " + crunchifyResultset.getString(2) + crunchifyResultset.getString(1));
        } else {
            throw new SQLException("Can NOT retrieve Genero details from table 'Genero'");
        }

        System.out.println("Oracle JDBC connect and query test completed.");
    }
}
