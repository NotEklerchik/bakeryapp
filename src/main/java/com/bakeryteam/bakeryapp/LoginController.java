package com.bakeryteam.bakeryapp;

import com.bakeryteam.bakeryapp.sql.UserdataTableController;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class LoginController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private CheckBox rememberMe;

    @FXML
    protected void onLoginButtonClick() {
        try {
            if(UserdataTableController.findUserAndPassword(username.getText(), password.getText())) {
                welcomeText.setText("Success.");
                if(rememberMe.isSelected()) {
                    welcomeText.setText("Success. Remembered.");
                }
                BakeryApplication.switchStage("info_menu", 1000, 500);
            } else {
                welcomeText.setText("Failed.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}