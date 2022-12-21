module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
    exports com.example.demo.enums;
    opens com.example.demo.enums to javafx.fxml;
    exports com.example.demo.constants;
    opens com.example.demo.constants to javafx.fxml;
}