package com.github.ericnaibert.calendarchallenge.storage;

import com.github.ericnaibert.calendarchallenge.calendar.ApplicationCalendar;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Calendar;

public class CheckNodes extends ApplicationCalendar {

    private static final ArrayList<ImageView> checkList = new ArrayList<>();

    public static void addToCheckList(ImageView node) {
        CheckNodes.checkList.add(node);
    }

    public static void removeChecksFromUI() {

        for(int i = 0; i < vBoxList.size(); i++) {
            vBoxList.get(i).getChildren().removeAll(getCheckList());
        }
    }

    public static ArrayList<ImageView> getCheckList() {
       return CheckNodes.checkList;
    }
}
