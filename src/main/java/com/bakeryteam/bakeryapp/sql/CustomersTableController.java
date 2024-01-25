package com.bakeryteam.bakeryapp.sql;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomersTableController extends AbstractTableController{

    public static synchronized int executeInsert(String firstName, String lastName, String email, Integer age) throws SQLException {
        return executeUpdateStatement(
                String.format("INSERT INTO customers (FirstName , LastName, Email, Age) VALUES ('%s', '%s', '%s', %d);",
                        firstName, lastName, email, age));

    }

    public static synchronized ResultSet executeSelect() throws SQLException {
        return executeQueryStatement("SELECT * FROM customers");
    }
}
