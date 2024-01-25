package com.bakeryteam.bakeryapp;

import com.bakeryteam.bakeryapp.sql.AbstractTableController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;

public class BakeryApplication extends Application {
    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        AbstractTableController.init();

        FXMLLoader fxmlLoader = new FXMLLoader(BakeryApplication.class.getResource("login_menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 240);
        stage.setTitle("Bakery SQL controller");
        stage.setScene(scene);
        stage.show();
    }

    public static void switchStage(String fxmlFile) {
        FXMLLoader fxmlLoader = new FXMLLoader(BakeryApplication.class.getResource(fxmlFile));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
            stage.setTitle("Bakery SQL controller");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void switchStage(String fxmlFile, int width, int height) {
        FXMLLoader fxmlLoader = new FXMLLoader(BakeryApplication.class.getResource(fxmlFile));
        Scene scene = null;
        stage.hide();
        try {
            scene = new Scene(fxmlLoader.load(), width, height);
            stage.setTitle("Bakery SQL controller");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void switchStage(String fxmlFile, boolean fullScreen) {
        FXMLLoader fxmlLoader = new FXMLLoader(BakeryApplication.class.getResource(fxmlFile));
        Scene scene = null;
        stage.hide();
        try {
            scene = new Scene(fxmlLoader.load(), );
            stage.setTitle("Bakery SQL controller");
            stage.setScene(scene);
            if (fullScreen) stage.setFullScreen(fullScreen);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) { launch(); }
}