package com.atden04.uclan_events_app.user_interface;

import com.atden04.uclan_events_app.models.Event;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {
    public Controller controller;
    private ObservableList<Event> events;

    public void initialise(Controller controller) {
        this.controller = controller;
        this.createEvents();
        this.controller.createEventWindow(this.events);
    }

    public void createEvents() {
        this.events = FXCollections.observableArrayList(
                new Event("Thrift Store", "Vintage-Folk-Fair.jpg"),
                new Event("Social Cricket", "Social-Cricket.jpg")
        );
    }
}
