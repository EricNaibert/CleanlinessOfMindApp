package com.github.ericnaibert.calendarchallenge;

import com.github.ericnaibert.calendarchallenge.calendar.ApplicationCalendar;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ApplicationInterface extends Application {

    public static Group root;

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(ApplicationInterface.class.getResource("hello-view.fxml"));
        String cssPath = String.valueOf(Main.class.getResource("Application.css"));

        root = new Group();
        root.getChildren().add(fxmlLoader.load());
        Scene scene = new Scene(root, 1000, 720);
        scene.getStylesheets().add(cssPath);

        ApplicationCalendar.calendar();

        stage.setTitle("Calendar Challenge");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @SuppressWarnings("unused")
    public static void init(String[] args) {
        Application.launch();
    }
}