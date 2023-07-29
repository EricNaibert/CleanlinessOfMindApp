package com.github.ericnaibert.calendarchallenge.calendar;

import com.github.ericnaibert.calendarchallenge.Main;
import com.github.ericnaibert.calendarchallenge.storage.DateStorage;
import com.github.ericnaibert.calendarchallenge.storage.PathDirectory;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;

import java.util.Objects;

public class CheckDayButton extends Calendar {

    private static Button button;

    public static void addCheckButton() {

        int buttonX = 750;
        int buttonY = 55;

        button = new Button();
        button.setBackground(Background.fill(Color.WHITE));
        button.setText("CHECK DAY");
        button.setId("buttonsId");
        button.setLayoutX(buttonX);
        button.setLayoutY(buttonY);

        button.setOnMouseClicked(event -> {

            String imgPath = String.valueOf(Main.class.getResource("images/green_checkmark.png"));
            Image checkImage = new Image((Objects.requireNonNull(imgPath)));

            TimeTools time = new TimeTools();
            PathDirectory file = new PathDirectory();


            //if(!file.getFileToSave().exists()) {

            DateStorage.storeDate();
            Calendar.vBoxList.get(time.getPositionToCheck()).getChildren().add(new ImageView(checkImage));



        });

        root.getChildren().add(button);
    }

    public static Button getButton() {
        return button;
    }
}
