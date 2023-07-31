package com.github.ericnaibert.calendarchallenge.calendar;

import com.github.ericnaibert.calendarchallenge.Main;
import com.github.ericnaibert.calendarchallenge.storage.CheckNodes;
import com.github.ericnaibert.calendarchallenge.storage.DateReader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class CheckDayOld {

    public static void checkOldDays(int arrayPositionForMonth) {

        String imgPath = String.valueOf(Main.class.getResource("images/green_checkmark.png"));
        Image checkImage = new Image((Objects.requireNonNull(imgPath)));
        ImageView greenCheck;

        for(int i = 0; i < DateReader.getDaysFromMonth(arrayPositionForMonth).size(); i++) {

            ApplicationCalendar.vBoxList.get(DateReader.getDaysFromMonth(arrayPositionForMonth).get(i)).getChildren().add(greenCheck = new ImageView(checkImage));

            CheckNodes.addToCheckList(greenCheck);
        }
    }

}
