package com.bakeryteam.bakeryapp;

import com.bakeryteam.bakeryapp.sql.CustomersTableController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        String str = "";
        CustomersTableController controller = new CustomersTableController();

        try {
            ResultSet resultSet = controller.executeSelect();
            while (resultSet.next()) {
                str += String.format("%s %s %s %d",
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Email"),
                        resultSet.getInt("Age")) + '\n';
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        welcomeText.setText(str);
    }
}