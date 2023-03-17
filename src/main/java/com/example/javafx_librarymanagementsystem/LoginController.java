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
    @FXML
    private Button borrowBook;
    @FXML
    private Button submit;
    @FXML
    private Button register;
    @FXML Button AddBooks;
    @FXML
    private Label errorLabel;
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
    // borrow book
    @FXML
    private void handleBorrowBookAction(ActionEvent event) throws IOException{
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("borrowBook.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }
    @FXML // add book
    private void handleExitButtonAction(ActionEvent event)throws IOException{
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("Library.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
        stage.toBack();
    }
    // add book function
    @FXML
    private void handleInsertButtonAction() {
        String query = "insert into books values("+idField.getText()+",'"+titleField.getText()+"','"+authorField.getText()+"',"+yearField.getText()+","+pagesField.getText()+")";
        executeQuery(query);
        showBooks();
    }
    // delete book function
    @FXML
    private void handleDeleteButtonAction() {
        String query = "DELETE FROM books WHERE ID="+idField.getText()+"";
        executeQuery(query);
        showBooks();
    }
    @FXML
    private void handleLogInButtonOnAction(){
        String query = "INSERT INTO login (username, password) VALUES ('"+usernameField.getText()+"','"+passwordField.getText()+"')";
        executeQuery(query);
        handleLogIn2ButtonAction();
    }

    // log in function
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
    //
    public void showBooks() {
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
                addBooks = new AddBooks(rs.getInt("id"),rs.getString("title"), rs.getString("author"),rs.getInt("year"),rs.getInt("pages"));
                booksList.add(addBooks);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        pagesColumn.setCellValueFactory(new PropertyValueFactory<>("pages"));
        TableView.setItems(booksList);
    }
    // readbook
    @FXML
    private void readBooks(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("Readbook.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void Readbooknext(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("Readbooknext.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("Library.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
        stage.toBack();
    }
    @FXML
    private void back2(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("readbook.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
        stage.toBack();
    }

    @FXML
    private void EndAction(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("readbook.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
        stage.close();
    }
    @FXML
    private void summitAction(ActionEvent event) throws IOException{
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("borrowBook2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void back3(ActionEvent event) throws IOException{
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("Library.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
        stage.toBack();
    }
    @FXML
    private void ReturnBook(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("ReturnBook.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void end3(ActionEvent event) throws IOException{
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("Library.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
        stage.toBack();

    }

    @FXML
    public ObservableList <Login> handleLogIn2ButtonAction(){
        ObservableList<Login> loginObservableList = FXCollections.observableArrayList();
        Connection connection = getConnection();
        String query = "SELECT * FROM login  ";
        Statement st1;
        ResultSet rs1;
        try {
            st1 = connection.createStatement();
            rs1 = st1.executeQuery(query);
            Login login;
            while(rs1.next()) {
                login = new Login(rs1.getString("username"),rs1.getInt("password"));
                loginObservableList.add(login);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loginObservableList;
    }

    /*@FXML
    private void handleLogIn3ButtonOnAction(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Check if the username and password are valid
        if (isValid(username, password)) {
            // If valid, continue to the next scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("nextScene.fxml"));
            try {
                Parent root = loader.load();
                Scene nextScene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(nextScene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // If invalid, display an error message
            errorLabel.setText("Invalid username or password");
        }
    }

    private boolean isValid(String username, String password) {
        if (username.equals("john_doe") && password.equals("password123")) {
            // Return true if valid
            return true;
        } else {
            // Return false otherwise
            return false;
        }
    }*/
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}

