package com.bakeryteam.bakeryapp;

import com.bakeryteam.bakeryapp.sql.AbstractTableController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;

public class BakeryApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        AbstractTableController.init();
        FXMLLoader fxmlLoader = new FXMLLoader(BakeryApplication.class.getResource("login_menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 240);
        stage.setTitle("Bakery SQL controller");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}