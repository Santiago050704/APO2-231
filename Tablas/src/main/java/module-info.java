module com.example.tablas {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tablas to javafx.fxml;
    exports com.example.tablas;

    opens com.example.tablas.model to javafx.fxml;
    exports com.example.tablas.model;
}