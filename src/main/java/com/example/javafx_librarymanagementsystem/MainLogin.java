package com.example.javafx_librarymanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainLogin extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainLogin.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 500);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("cadtLogo.png")));
        stage.setTitle("Cambodia Academy of Digital Technology");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
       /* File file = new file("");
        try{
            file.createNewFile();
        } catch (IOException e){
            e.printStackTrace();
        }*/
        launch(args);
    }
}
