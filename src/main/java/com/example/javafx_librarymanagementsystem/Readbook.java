package com.example.javafx_librarymanagementsystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

//import static jdk.jpackage.internal.WixAppImageFragmentBuilder.ShortcutsFolder.Desktop;


public class Readbook implements Initializable {
    //FileChooser fileChooser = new FileChooser();
    @FXML
    private TextArea textArea;

    @FXML
    void getText(MouseEvent event){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      //  fileChooser.setInitialDirectory(new File())
    }
    public void read(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("Link click");
        //Desktop.getClass().browse(new URI("http://www.youtube.com"))
    }

    private Hyperlink hyperlink;
}
