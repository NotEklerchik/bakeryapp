package com.bakeryteam.bakeryapp.sql;

import java.sql.*;

abstract class AbstractTableController {
    protected static Connection DataBaseConnection = establishNewConnection();

    protected ResultSet resultSet;

    protected static Connection establishNewConnection() {
        String url = "jdbc:postgresql://26.145.103.85:5432/bakerydb";
        String user = "postgres";
        String passwd = "Hjvfirf11";

        Connection connection;
        try {
            connection = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            throw new RuntimeException();
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }

        return connection;
    }

    protected static int executeUpdateStatement(String query) throws SQLException {
        Statement statement = DataBaseConnection.createStatement();
        return statement.executeUpdate(query);
    }

    protected static ResultSet executeQueryStatement(String query) throws SQLException {
        Statement statement = DataBaseConnection.createStatement();
        return statement.executeQuery(query);
    }

    protected int executeInsert() throws SQLException {
        return -1;
    }
    protected int executeUpdate() throws SQLException {
        return -1;
    }
    protected int executeDelete() throws SQLException {
        return -1;
    }
    protected ResultSet executeSelect() throws SQLException {
        return null;
    }

    protected ResultSet getResultSet() {
        return resultSet;
    }


}
