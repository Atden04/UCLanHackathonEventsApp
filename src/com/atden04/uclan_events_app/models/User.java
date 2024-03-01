package com.atden04.uclan_events_app.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class User {
    private String name;
    private String email;
    private String password;
    private ObservableList<Event> registeredEvents;
    private int reminderPreference;

    public User(String name, String email, String password)
    {
        this.name = name;
        this.email = email;
        this.password = password;
        this.registeredEvents = FXCollections.observableArrayList();
    }

    public void registerEvent(Event event)
    {
        this.registeredEvents.addLast(event);
    }

    public void unregisterEvent(Event event) {
        registeredEvents.remove(event);
    }
}
