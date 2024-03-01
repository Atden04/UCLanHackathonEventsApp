package com.atden04.uclan_events_app.user_interface;

import com.atden04.uclan_events_app.models.Event;
import com.atden04.uclan_events_app.models.modelParser;
import com.atden04.uclan_events_app.models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Objects;

public class Model {
    public Controller controller;
    private modelParser parser;
    private ObservableList<Event> events;
    private ObservableList<User> users;
    private User currentUser;
    private boolean isUserLoggedIn;

    public Model()
    {
        System.out.println("Model Constructed");
        this.events = FXCollections.observableArrayList();
        this.users = FXCollections.observableArrayList();
    }

    public void initialise(Controller controller, modelParser parser) {
        this.isUserLoggedIn = false;
        this.controller = controller;
        this.parser = parser;
        this.parser.parseEvents("C:\\Users\\Alexa\\IdeaProjects\\UCLanHackathonEventsApp\\src\\com\\atden04\\uclan_events_app\\res\\events.csv", this.events);
        this.controller.createEventWindow(this.events);
        this.parser.parseUsers("C:\\Users\\Alexa\\IdeaProjects\\UCLanHackathonEventsApp\\src\\com\\atden04\\uclan_events_app\\res\\users.csv", this.users);
    }

    public void registerEvent(Event event)
    {
        currentUser.registerEvent(event);
    }

    public void unregisterEvent(Event event) {
        currentUser.unregisterEvent(event);
    }

    public boolean isUserLoggedIn() {
        return isUserLoggedIn;
    }

    public String loginUser(String inputtedEmail, String inputtedPassword) {
        String returnStr = new String("");
        if (this.isEmailRegisterd(inputtedEmail)) {
            for (User u: users) {
                if (Objects.equals(u.getPassword(inputtedEmail), inputtedPassword)) {
                    returnStr = "You are now logged in.";
                    isUserLoggedIn = true;
                    currentUser = u;
                }
            }
            if (!isUserLoggedIn)
            {
                returnStr = "The password entered is incorrect.";
            }
        }
        else {
            returnStr = "The email entered does not belong to a registered user.";
        }
        return returnStr;
    }

    private boolean isEmailRegisterd(String email) {
        boolean returnBool = false;
        for (User u : users) {
            if (Objects.equals(u.getEmail(), email)) {
                returnBool = true;
            }
        }
        return returnBool;
    }

    public User getCurrentUser() {
        return this.currentUser;
    }
}
