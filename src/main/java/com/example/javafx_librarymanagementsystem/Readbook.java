package com.example.javafx_librarymanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.net.URL;
import java.util.ResourceBundle;

public class Readbook implements Initializable {

    FileChooser fileChooser = new FileChooser();
    public void back(ActionEvent event) {
    }
    @FXML
    private TextArea textArea;
    @FXML
    void getText(MouseEvent event){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
