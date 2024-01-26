package com.bakeryteam.bakeryapp;

import com.bakeryteam.bakeryapp.sql.AbstractTableController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class BakeryApplication extends Application {
    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        AbstractTableController.init();

        FXMLLoader fxmlLoader = new FXMLLoader(BakeryApplication.class.getResource("login_menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 240);
        scene.getStylesheets().add(Objects.requireNonNull(BakeryApplication.class.getResource("login_menu.css")).toString());
        stage.setTitle("Bakery SQL controller");
        stage.setScene(scene);
        stage.show();
    }

    public static void switchStage(String fileName) {
        FXMLLoader fxmlLoader = new FXMLLoader(BakeryApplication.class.getResource(fileName));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
            scene.getStylesheets().add(BakeryApplication.class.getResource(fileName + ".css").toString());
            stage.setTitle("Bakery SQL controller");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void switchStage(String fileName, int width, int height) {
        FXMLLoader fxmlLoader = new FXMLLoader(BakeryApplication.class.getResource(fileName + ".fxml"));
        Scene scene = null;
        stage.hide();
        try {
            scene = new Scene(fxmlLoader.load(), width, height);
            scene.getStylesheets().add(BakeryApplication.class.getResource(fileName + ".css").toString());
            stage.setTitle("Bakery SQL controller");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void switchStage(String fileName, boolean fullScreen) {
        FXMLLoader fxmlLoader = new FXMLLoader(BakeryApplication.class.getResource(fileName + ".fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
            scene.getStylesheets().add(BakeryApplication.class.getResource(fileName + ".css").toString());
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