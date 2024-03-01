package com.atden04.uclan_events_app.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Objects;

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

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword(String email) {
        String returnStr = new String("");
        if (Objects.equals(email, this.email)) {
            returnStr = this.password;
        }
        return returnStr;
    }
}
