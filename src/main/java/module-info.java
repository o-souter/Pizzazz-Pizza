module uk.ac.rgu.cm2100c2p1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.desktop;

    opens uk.ac.rgu.cm2100 to javafx.fxml; 
    opens uk.ac.rgu.cm2100.controllers to javafx.fxml;
    
    exports uk.ac.rgu.cm2100;
    exports uk.ac.rgu.cm2100.controllers;
}
