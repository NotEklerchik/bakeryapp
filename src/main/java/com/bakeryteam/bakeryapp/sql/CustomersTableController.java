package com.bakeryteam.bakeryapp.sql;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomersTableController extends AbstractTableController{

    private String firstName;
    private String lastName;
    private String email;
    private int age;

    @Override
    public int executeInsert() throws SQLException {
        return executeUpdateStatement(
                String.format("INSERT INTO customers (FirstName , LastName, Email, Age) VALUES ('%s', '%s', '%s', %d);",
                        firstName, lastName, email, age)
        );
    }

    @Override
    public ResultSet executeSelect() throws SQLException {
        return executeQueryStatement("SELECT * FROM customers");
    }

    public CustomersTableController setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CustomersTableController setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CustomersTableController setEmail(String email) {
        this.email = email;
        return this;
    }

    public CustomersTableController setAge(int age) {
        this.age = age;
        return this;
    }
}
