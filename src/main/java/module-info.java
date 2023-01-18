module com.example.latihan5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.latihan5 to javafx.fxml;
    exports com.example.latihan5;
}