module com.example.hipoteca {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hipoteca to javafx.fxml;
    exports com.example.hipoteca;
}