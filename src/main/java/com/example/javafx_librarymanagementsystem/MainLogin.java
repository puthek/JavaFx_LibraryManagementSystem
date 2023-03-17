package com.example.javafx_librarymanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
public class MainLogin extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainLogin.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 500);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("cadtLogo.png")));
        stage.setTitle("Cambodia Academy of Digital Technology");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}


