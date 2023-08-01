package com.github.ericnaibert.calendarchallenge.calendar;

import com.github.ericnaibert.calendarchallenge.Main;
import com.github.ericnaibert.calendarchallenge.calendar.month.CalendarMonthChanger;
import com.github.ericnaibert.calendarchallenge.storage.CheckNodes;
import com.github.ericnaibert.calendarchallenge.storage.DateStorage;
import com.github.ericnaibert.calendarchallenge.storage.PathDirectory;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;

import java.util.Objects;

public class CheckDayButton extends ApplicationCalendar {

    private static boolean todayCheck = false;
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
            ImageView imageView;

            TimeTools time = new TimeTools();
            PathDirectory file = new PathDirectory();

            if(!file.getFileToSave().exists()) {

                DateStorage.storeDate();
                ApplicationCalendar.vBoxList.get(time.getPositionToCheck()).getChildren().add(imageView = new ImageView(checkImage));

                CheckNodes.addToCheckList(imageView);
            }

            if(file.getFileToSave().exists()) {

                if(CalendarMonthChanger.getLastSavedDay() != time.getPositionToCheck() && !todayCheck) {

                    DateStorage.storeDate();
                    ApplicationCalendar.vBoxList.get(time.getPositionToCheck()).getChildren().add(imageView = new ImageView(checkImage));

                    CheckNodes.addToCheckList(imageView);

                    todayCheck = true;
                }
            }

        });

        //#7=[31, 32, 33, 34, 35, 36]/2023#

        root.getChildren().add(button);
    }

    public static boolean isTodayCheck() {
        return todayCheck;
    }

    public static Button getButton() {
        return button;
    }
}
