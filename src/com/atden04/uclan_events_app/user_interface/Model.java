package com.atden04.uclan_events_app.user_interface;

import com.atden04.uclan_events_app.models.Event;
import com.atden04.uclan_events_app.models.modelParser;
import com.atden04.uclan_events_app.models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Objects;

/**
 * Class for the Model, helping to implement MVC Design Pattern
 */
public class Model {
    /**
     * Reference to controller to interact with user interface
     */
    public Controller controller;
    /**
     * Reference to parser for the Model
     */
    private modelParser parser;
    /**
     * ObservableList containing all the Event objects
     */
    private ObservableList<Event> events;
    /**
     * ObservableList containing all the User objects
     */
    private ObservableList<User> users;
    /**
     * Attribute containing reference to current user object
     */
    private User currentUser;
    /**
     * Boolean attribute to indicate if user is logged in
     */
    private boolean isUserLoggedIn;

    /**
     * Constructor for the Model
     */
    public Model()
    {
        System.out.println("Model Constructed");
        this.events = FXCollections.observableArrayList();
        this.users = FXCollections.observableArrayList();
    }

    /**
     * Public method to initialise the Model
     * @param controller reference to the controller object
     * @param parser reference to the parser obejct
     */
    public void initialise(Controller controller, modelParser parser) {
        this.isUserLoggedIn = false;
        this.controller = controller;
        this.parser = parser;
        this.parser.parseEvents("C:\\Users\\Alexa\\IdeaProjects\\UCLanHackathonEventsApp\\src\\com\\atden04\\uclan_events_app\\res\\events.csv", this.events);
        this.controller.createEventWindow(this.events);
        this.parser.parseUsers("C:\\Users\\Alexa\\IdeaProjects\\UCLanHackathonEventsApp\\src\\com\\atden04\\uclan_events_app\\res\\users.csv", this.users);
    }

    /**
     * Method to register an event to the current User.
     * @param event reference to the inputted event object
     */
    public void registerEvent(Event event)
    {
        currentUser.registerEvent(event);
    }

    /**
     * Method to remove an event from the current User.
     * This means they will no longer receive notifications for this event.
     * @param event reference to the inputted event object
     */
    public void unregisterEvent(Event event) {
        currentUser.unregisterEvent(event);
    }

    /**
     * Getter to check if user is logged in.
     * @return attribute to indicate if user is logged in.
     */
    public boolean isUserLoggedIn() {
        return isUserLoggedIn;
    }

    /**
     * Method to log in user. Check's the details inputted and will indicate if user is registered,
     * or if the password is correct if they are registered or if they've successfully logged in.
     * @param inputtedEmail string containing the inputted email
     * @param inputtedPassword string containing the inputted password
     * @return string message to output to user indicating outcome of the log in
     */
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

    /**
     * Private method to check if user's email is registered
     * @param email string containing user's email
     * @return boolean value to indicate if user is registered
     */
    private boolean isEmailRegisterd(String email) {
        boolean returnBool = false;
        for (User u : users) {
            if (Objects.equals(u.getEmail(), email)) {
                returnBool = true;
            }
        }
        return returnBool;
    }

    /**
     * Public method to return the current user.
     * @return reference to current user object.
     */
    public User getCurrentUser() {
        return this.currentUser;
    }
}
