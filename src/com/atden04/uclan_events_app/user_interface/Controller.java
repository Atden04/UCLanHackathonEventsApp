package com.atden04.uclan_events_app.user_interface;

import com.atden04.uclan_events_app.models.Event;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Controller {

    @FXML
    public MenuItem loginMenu;
    @FXML
    public MenuItem myReservationMenu;
    @FXML
    public MenuItem SignOutMenu;
    @FXML
    private VBox eventWindow;
    private ObservableList<CheckBox> checkBoxes;
    Model model;
    Stage stage;

    public Controller() {
        System.out.println("Controller constructed");
        checkBoxes = FXCollections.observableArrayList();
    }

    public void initialise(Model model, Stage stage) {
        this.model = model;
        this.stage = stage;
    }

    public void createEventWindow(ObservableList<Event> events) {
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
                    if (model.isUserLoggedIn()) {
                        if (registerBox.isSelected()) {
                            model.registerEvent(e);
                        }
                        else {
                            model.unregisterEvent(e);
                        }
                    } else {
                        registerBox.setSelected(false); //ensures CheckBox is not checked
                        System.out.println("You can't register for the event as you're not logged in.");
                    }
                }
            });
            checkBoxes.addLast(registerBox);

            VBox eventInfoBox= new VBox(eventNameLabel, eventDateLabel, registerBox);
            System.out.println(e.getDate().toString());
            eventContainer.getChildren().addAll(eventImage, eventInfoBox);
            eventWindow.getChildren().addLast(eventContainer);
        }

    }

    public void handleLogin(ActionEvent actionEvent) {
        Stage loginStage = new Stage();
        loginStage.initOwner(stage);
        Label emailLabel = new Label("Enter Email:");
        TextField emailInput = new TextField();
        emailInput.setPromptText("Email");
        Label passwordLabel = new Label("Enter Password:");
        TextField passwordInput = new TextField();
        passwordInput.setPromptText("Password");
        Label loginResultLabel = new Label();

        final Button loginButton = new Button ("Login");

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                String inputtedEmail = emailInput.getText();
                String inputtedPassword = passwordInput.getText();

                loginResultLabel.setText(model.loginUser(inputtedEmail, inputtedPassword));
            }
        });

        VBox vBox = new VBox(emailLabel, emailInput, passwordLabel, passwordInput, loginResultLabel, loginButton);
        vBox.alignmentProperty().set(Pos.CENTER);
        vBox.setSpacing(10);

        Scene loginScene = new Scene(vBox, 410, 200);
        loginStage.setScene(loginScene);
        loginStage.show();
        loginStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {

            }
        });
    }
}
