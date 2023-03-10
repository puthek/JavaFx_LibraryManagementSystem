package com.example.javafx_librarymanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainLogin extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainLogin.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 500);
        stage.getIcons().add(new Image("D:\\JAVAFX Project\\image\\cadtLogo.png"));
        stage.setTitle("Cambodia Academy of Digital Technology");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("input a number ");
            int n1 = sc.nextInt();
            System.out.println("INPUT A NUMBER 2");
            int n2 = sc.nextInt();
            System.out.println(n1 +"/" + n2 +"="+ n1/n2);
        }catch (InputMismatchException e){
            System.out.println("there is an error!");
        }
    }
}