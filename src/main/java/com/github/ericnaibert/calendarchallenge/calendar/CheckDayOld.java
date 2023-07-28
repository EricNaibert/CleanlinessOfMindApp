package com.github.ericnaibert.calendarchallenge.calendar;

import com.github.ericnaibert.calendarchallenge.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class CheckDayOld {

    public static void checkOldDays() {

        String imgPath = String.valueOf(Main.class.getResource("images/green_checkmark.png"));
        Image checkImage = new Image((Objects.requireNonNull(imgPath)));

        TimeTools time = new TimeTools();
        for(int i = 0; i < time.getOlderPositions().size(); i++) {
            Calendar.vBoxList.get(time.getOlderPositions().get(i)).getChildren().add(new ImageView(checkImage));
        }

    }

}
