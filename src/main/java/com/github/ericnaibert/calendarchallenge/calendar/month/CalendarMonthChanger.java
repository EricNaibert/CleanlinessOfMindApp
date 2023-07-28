package com.github.ericnaibert.calendarchallenge.calendar.month;

import com.github.ericnaibert.calendarchallenge.ApplicationInterface;
import com.github.ericnaibert.calendarchallenge.calendar.TimeTools;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.time.LocalDate;

public class CalendarMonthChanger extends ApplicationInterface {

    public static void monthProperties() {

        TimeTools time = new TimeTools();

        HBox hBox = new HBox();
        hBox.setLayoutX(300);
        hBox.setLayoutY(70);
        hBox.setPrefHeight(30);
        hBox.setPrefWidth(400);
        hBox.setSpacing(100);
        hBox.setAlignment(Pos.CENTER);
        hBox.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 0.7;");

        String showMonth;
        showMonth = String.valueOf(LocalDate.of(time.getYearNow(), time.getMonthNow(), 1).getMonth());

        MonthButtonHandler monthButtonHandler = new MonthButtonHandler();
        Button previousMonth = new Button("<");
        previousMonth.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        previousMonth.setId("monthAndYearId");
        previousMonth.setOnMouseClicked(monthButtonHandler.previousEventHandler);
        hBox.getChildren().add(previousMonth);

        Label monthAndYear = new Label();
        monthAndYear.setText(showMonth + ", " + time.getYearNow());
        monthAndYear.setId("monthAndYearId");
        hBox.getChildren().add(monthAndYear);

        Button nextMonth = new Button(">");
        nextMonth.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        nextMonth.setId("monthAndYearId");
        nextMonth.setOnMouseClicked(monthButtonHandler.nextEventHandler);
        hBox.getChildren().add(nextMonth);

        root.getChildren().add(hBox);

    }

}
