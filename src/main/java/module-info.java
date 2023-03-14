module com.example.javafx_librarymanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.javafx_librarymanagementsystem to javafx.fxml;
    exports com.example.javafx_librarymanagementsystem;
}