module com.example.javafx_librarymanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;



    opens com.example.javafx_librarymanagementsystem to javafx.fxml;
    exports com.example.javafx_librarymanagementsystem;
}