package com.github.ericnaibert.calendarchallenge.calendar;

import com.github.ericnaibert.calendarchallenge.ApplicationInterface;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Calendar extends ApplicationInterface {

    private static final List<VBox> vBoxList = new ArrayList<>();

    public static void calendar() {

        Color translucentWhite = new Color(1.0, 1.0, 1.0, 0.5);

        int monthNow = LocalDate.now().getMonthValue();
        int yearNow = LocalDate.now().getYear();
        int lengthOfMonth = LocalDate.now().lengthOfMonth();
        int firstDayOfMonth = LocalDate.of(yearNow, monthNow, 1).getDayOfWeek().getValue();

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

        for(int j = 0; j < lengthOfMonth; j++) {

            Label dayNumber;
            vBoxList.get(j+firstDayOfMonth).getChildren().add(dayNumber = new Label());
            dayNumber.setText(String.valueOf(j+1));
            dayNumber.setId("dayNumberId");
        }

        DayNameLabel.dayNameLabel();
        root.getChildren().add(flowPane);

    }
}