package com.atden04.uclan_events_app.user_interface;

import com.atden04.uclan_events_app.models.modelParser;
import com.atden04.uclan_events_app.models.User;
import com.atden04.uclan_events_app.res.ResourceManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

/**
 * Main class that extends the JavaFX Application class
 */
public class Main extends Application {

    /**
     * Object for the model of the program
     */
    Model model;
    /**
     * Object for the controller of the program
     */
    Controller controller;
    /**
     * Object for the parser to read in data from csv files to populate the model
     */
    modelParser parser;

    /**
     * Start function for the JavaFX which creates and initialises the objects within the main class
     * Loads in the fxml file for the mainScene and imports the stylesheet.
     * @param stage Window where the user interacts with the application
     * @throws Exception Throws Exception if program can't load fxml file
     */
    @Override
    public void start(Stage stage) throws Exception {

        //Create attributes
        this.parser = new modelParser();
        this.model = new Model();
        this.controller = new Controller();

        //Load in the fxml file
        FXMLLoader loader = new FXMLLoader(ResourceManager.getFxml("mainScene.fxml"));
        loader.setControllerFactory((Klass) -> this.controller);

        //set up the scene to create elements to
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(ResourceManager.getCss("style.css").toExternalForm());

        //Initialise controller and model.
        //This happens after constructor, so you can supply both objects with references to the other.
        //You can't do this with null objects.
        this.controller.initialise(this.model, stage);
        this.model.initialise(this.controller,this.parser);

        //Set title of the Window
        stage.setTitle("UCLan Events");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Override to handle code when closing the app but before the program finishes.
     */
    @Override
    public void stop() {
        System.out.println("Closing the App..");
    }

    /**
     * Main function that calls the launch of javaFX libraries
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}