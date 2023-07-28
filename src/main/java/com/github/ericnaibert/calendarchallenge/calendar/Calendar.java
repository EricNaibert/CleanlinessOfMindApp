package com.github.ericnaibert.calendarchallenge.calendar;

import com.github.ericnaibert.calendarchallenge.ApplicationInterface;
import com.github.ericnaibert.calendarchallenge.calendar.month.CalendarMonthChanger;
import com.github.ericnaibert.calendarchallenge.storage.DayMonthReader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Calendar extends ApplicationInterface {

    public static final List<VBox> vBoxList = new ArrayList<>();

    public static void calendar() {

        TimeTools time = new TimeTools();
        Color translucentWhite = new Color(1.0, 1.0, 1.0, 0.5);

        FlowPane flowPane = new FlowPane();
        flowPane.setPrefWidth(900);
        flowPane.setPrefHeight(540);
        flowPane.setHgap(0);
        flowPane.setVgap(0);
        flowPane.setBackground(new Background(new BackgroundFill(translucentWhite, CornerRadii.EMPTY, Insets.EMPTY)));
        flowPane.setLayoutX(50);
        flowPane.setLayoutY(150);
        flowPane.setAlignment(Pos.CENTER);

        for(int i = 0; i < 42; i++){

            VBox vBox = new VBox();
            vBox.setPrefWidth(128);
            vBox.setPrefHeight(90);
            vBox.setAlignment(Pos.CENTER);
            vBox.setStyle("-fx-border-color: black;" + "-fx-border-width: 0.7;");

            vBoxList.add(vBox);

            flowPane.getChildren().add(vBox);
        }

        for(int j = 0; j < time.getLengthOfMonth(); j++) {

            Label dayNumber;
            vBoxList.get(j+time.getFirstDayOfMonth()).getChildren().add(dayNumber = new Label());
            dayNumber.setText(String.valueOf(j+1));
            dayNumber.setId("dayNumberId");
        }

        DayMonthReader.dayMonthReader();
        DayNameLabel.dayNameLabel();

        CalendarMonthChanger.monthProperties();

        root.getChildren().add(flowPane);
    }
}