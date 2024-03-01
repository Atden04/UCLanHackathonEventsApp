package com.atden04.uclan_events_app.user_interface;

import com.atden04.uclan_events_app.models.Event;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Controller {


    @FXML
    private VBox eventWindow;
    /*@FXML
    private HBox eventBox;
    @FXML
    private Label eventLabel;
    @FXML
    private ImageView eventImage;*/
    Model model;
    Stage stage;

    public Controller() {
        System.out.println("Controller constructed");
    }

    public void initialise(Model model, Stage stage) {
        this.model = model;
        this.stage = stage;
    }

    public void createEventWindow(ObservableList<Event> events)
    {
        for (Event e : events) {
            HBox eventContainer = new HBox();
            eventContainer.prefHeight(120);
            eventContainer.prefWidth(460);

            ImageView eventImage = new ImageView();
            eventImage.setFitHeight(120);
            eventImage.setFitWidth(120);
            Image image = new Image(e.getImagePath());
            eventImage.setImage(image);

            Label eventNameLabel = new Label(e.getName());
            eventNameLabel.minHeight(137);
            eventNameLabel.minHeight(367);
            eventNameLabel.setTextAlignment(TextAlignment.CENTER);
            eventNameLabel.setAlignment(Pos.CENTER);
            eventNameLabel.setFont(new Font(18));
            eventNameLabel.setPadding(new Insets(5,0,0,20));

            Label eventDateLabel = new Label(e.getDate().toString());
            eventDateLabel.setFont(new Font(15));
            eventDateLabel.setPadding(new Insets(5,0,0,25));

            CheckBox registerBox = new CheckBox("Register");
            registerBox.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    if (registerBox.isSelected()) {
                        model.registerEvent(e);
                    }
                    else {
                        model.unregisterEvent(e);
                    }
                }
            });

            VBox eventInfoBox= new VBox(eventNameLabel, eventDateLabel, registerBox);
            System.out.println(e.getDate().toString());
            eventContainer.getChildren().addAll(eventImage, eventInfoBox);
            eventWindow.getChildren().addLast(eventContainer);
        }

    }
}
