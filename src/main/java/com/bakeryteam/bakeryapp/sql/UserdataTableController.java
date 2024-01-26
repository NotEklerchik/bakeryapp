package com.bakeryteam.bakeryapp.sql;

import com.bakeryteam.bakeryapp.sql.AbstractTableController;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserdataTableController extends AbstractTableController {

    public static synchronized int executeInsert(String password, String username) throws SQLException {
        return executeUpdateStatement(
                String.format("INSERT INTO userdata (password , username) VALUES ('%s', '%s');",
                        password, username));
    }

    public static synchronized ResultSet executeSelect() throws SQLException {
        return executeQueryStatement(
                String.format("SELECT * FROM userdata"));
    }

    public static synchronized boolean findUserAndPassword(String password, String username) throws SQLException {
        ResultSet resultSet = executeQueryStatement(
                String.format("SELECT * FROM \"UserData\" WHERE \"UserName\" = '%s' AND \"Password\" = '%s';",
                password, username));
        return resultSet.next() != false;
    }
}
