package com.atden04.uclan_events_app.user_interface;

import com.atden04.uclan_events_app.models.EventParser;
import com.atden04.uclan_events_app.models.User;
import com.atden04.uclan_events_app.res.ResourceManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main extends Application {

    Model model;
    Controller controller;
    EventParser parser;

    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("scene.fxml"));

        this.parser = new EventParser();
        this.model = new Model();
        this.controller = new Controller();
        User currentUser = new User("alex", "email", "word");

        FXMLLoader loader = new FXMLLoader(ResourceManager.getFxml("mainScene.fxml"));
        loader.setControllerFactory((Klass) -> this.controller);

        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(ResourceManager.getCss("style.css").toExternalForm());

        this.controller.initialise(this.model, stage);
        this.model.initialise(this.controller,this.parser, currentUser);

        stage.setTitle("UCLan Events");
        stage.setScene(scene);
        stage.show();
    }

    /*@Override
    public void stop() {
        System.out.println("Closing the App..");
    }*/

    public static void main(String[] args) {
        launch(args);
    }
}