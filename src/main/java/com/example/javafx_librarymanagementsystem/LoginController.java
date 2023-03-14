package com.example.javafx_librarymanagementsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    public Button CancelButton;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button LoginButton;
    @FXML
    private Button SignInButton;
    @FXML
    private TextField idField;
    @FXML
    private TextField titleField;
    @FXML
    private TextField authorField;
    @FXML
    private TextField yearField;
    @FXML
    private TextField pagesField;
   @FXML
   private Button InsertButton;
   @FXML
   private Button DeleteButton;
    @FXML
    private TableColumn<AddBooks, Integer> idColumn;
    @FXML
    private TableColumn<AddBooks, String> titleColumn;
    @FXML
    private TableColumn<AddBooks, String> authorColumn;
    @FXML
    private TableColumn<AddBooks, Integer> yearColumn;
    @FXML
    private TableColumn<AddBooks, Integer> pagesColumn;
    @FXML
    private TableView<AddBooks> TableView;
    @FXML Button AddBooks;
    private Stage stage;
    private Scene scene;
    @FXML // move to main screen
    private void handleLoginButtonAction(ActionEvent event) throws IOException{
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("Library.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }
    @FXML // move to register screen
    private void handleSignInButtonAction(ActionEvent event) throws IOException{
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }
    @FXML // move to main screen of register's screen
    private void handleRegisterButtonAction(ActionEvent event) throws IOException{
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("Library.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }
    @FXML // cancel and close program os login first screen
    private void handleCancelButtonActionLogin(ActionEvent event)throws IOException{
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
        stage.close();
    }
    @FXML // go back to log in screen of register screen
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
    @FXML // add book
    private void handleAddBooksButtonAction(ActionEvent event)throws IOException{
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("AddBooks.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void InsertButton() {
        String query = "insert into books values("+idField.getText()+",'"+titleField.getText()+"','"+authorField.getText()+"',"+yearField.getText()+","+pagesField.getText()+")";
        executeQuery(query);
        showBooks();
    }
    @FXML
    private void DeleteButton() {
        String query = "DELETE FROM books WHERE ID="+idField.getText()+"";
        executeQuery(query);
        showBooks();
    }
    public void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showBooks();
    }
    public Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","9644");
            return conn;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public ObservableList<AddBooks> getBooksList1(){
        ObservableList<AddBooks> booksList = FXCollections.observableArrayList();
        Connection connection = getConnection();
        String query = "SELECT * FROM books ";
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            AddBooks addBooks;
            while(rs.next()) {
                addBooks = new AddBooks(rs.getInt("Id"),rs.getString("Title"), rs.getString("Author"),rs.getInt("Year"),rs.getInt("Pages"));
                booksList.add(addBooks);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return booksList;
    }
    private void showBooks() {
        ObservableList<AddBooks> list = getBooksList1();

        idColumn.setCellValueFactory(new PropertyValueFactory<AddBooks,Integer>("id"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<AddBooks,String>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<AddBooks,String>("author"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<AddBooks,Integer>("year"));
        pagesColumn.setCellValueFactory(new PropertyValueFactory<AddBooks,Integer>("pages"));

        TableView.setItems(list);}

}
