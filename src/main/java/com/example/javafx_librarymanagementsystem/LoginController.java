package com.example.javafx_librarymanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;
    private Stage stage;
    private Scene scene;
    @FXML
    private void handleLoginButtonAction(ActionEvent event) throws IOException{
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("Library.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void handleSignInButtonAction(ActionEvent event) throws IOException{
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void handleRegisterButtonAction(ActionEvent event) throws IOException{
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("Library.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void handleCancelButtonActionLogin(ActionEvent event)throws IOException{



        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
        stage.close();
    }
    @FXML
    private void handleCancelButtonActionScene2(ActionEvent event)throws IOException{
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Log out");
        alert.setHeaderText("you are about log out");
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
        stage.toBack();
    }






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
