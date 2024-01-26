package com.bakeryteam.bakeryapp.sql;

import java.sql.*;

abstract public class AbstractTableController {
    protected static Connection DataBaseConnection;

    public static boolean init() {

        DataBaseConnection = establishNewConnection();
        return DataBaseConnection != null;
    }

    public static void closeConnection() {
        try {
            DataBaseConnection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

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
            System.out.println("Successfully connected to database");
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

    protected static Connection getDataBaseConnection() {
        return DataBaseConnection;
    }
}
