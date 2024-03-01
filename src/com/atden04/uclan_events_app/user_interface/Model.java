package com.atden04.uclan_events_app.user_interface;

import com.atden04.uclan_events_app.models.Event;
import com.atden04.uclan_events_app.models.EventParser;
import com.atden04.uclan_events_app.models.User;
import com.atden04.uclan_events_app.res.ResourceManager;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Model {
    public Controller controller;
    private EventParser parser;
    private ObservableList<Event> events;
    private ObservableList<User> users;
    private User currentUser;

    public Model()
    {
        System.out.println("Model Constructed");
        this.events = FXCollections.observableArrayList();
        this.users = FXCollections.observableArrayList();
    }

    public void initialise(Controller controller, EventParser parser, User user) {
        this.controller = controller;
        this.parser = parser;
        this.parser.parseEvents("C:\\Users\\Alexa\\IdeaProjects\\UCLanHackathonEventsApp\\src\\com\\atden04\\uclan_events_app\\res\\events.csv", this.events);
        this.controller.createEventWindow(this.events);
        this.currentUser = user;
    }

    public void registerEvent(Event event)
    {
        currentUser.registerEvent(event);
    }

    public void unregisterEvent(Event event) {
        currentUser.unregisterEvent(event);
    }
}
