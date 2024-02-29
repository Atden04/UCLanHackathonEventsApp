module Test.Java {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;

    opens com.atden04.uclan_events_app.user_interface to javafx.fxml;
    exports com.atden04.uclan_events_app.user_interface;
    exports com.atden04.uclan_events_app.res;
    opens com.atden04.uclan_events_app.res to javafx.fxml;
}