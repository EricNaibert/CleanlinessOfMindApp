package com.github.ericnaibert.calendarchallenge.calendar;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;

public class CheckDayButton extends Calendar {

    public static void addCheckButton() {

        int buttonX = 750;
        int buttonY = 55;

        Button button = new Button();
        button.setBackground(Background.fill(Color.WHITE));
        button.setText("CHECK DAY");
        button.setId("buttonsId");
        button.setLayoutX(buttonX);
        button.setLayoutY(buttonY);

        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                System.out.println("BUTTON CLICKED");

            }
        });

        root.getChildren().add(button);
    }

}
