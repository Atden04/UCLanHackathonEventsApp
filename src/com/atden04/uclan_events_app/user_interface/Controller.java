package com.atden04.uclan_events_app.user_interface;

import com.atden04.uclan_events_app.models.Event;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
    @FXML
    private HBox eventBox;
    @FXML
    private Label eventLabel;
    @FXML
    private ImageView eventImage;
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
            Label eventLabel = new Label(e.getName());
            eventLabel.minHeight(137);
            eventLabel.minHeight(367);
            eventLabel.setTextAlignment(TextAlignment.CENTER);
            eventLabel.setAlignment(Pos.BOTTOM_LEFT);
            eventLabel.setFont(new Font(22));
            eventLabel.setPadding(new Insets(0,0,0,20));
            eventContainer.getChildren().addAll(eventImage, eventLabel);
            eventWindow.getChildren().addLast(eventContainer);
        }

    }
}
