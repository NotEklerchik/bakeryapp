package com.bakeryteam.bakeryapp.sql;

import java.sql.*;

public class DatabaseControl {

    private static final Connection connection = getNewConnection();
    public static void main(String[] args) {
        CustomersTableController controller = new CustomersTableController();
        //controller.setAge().setFirstName().setLastName().setEmail().executeInsert();
    }

    private static Connection getNewConnection() {
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

    private static int executeUpdateStatement(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeUpdate(query);
    }

    private static ResultSet executeStatementWithResult(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    enum Count {
        ALL,
        LAST
    }
}
