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


public class CalendarMonthChanger extends ApplicationInterface {

    protected static Label monthAndYear;

    public static void monthProperties() {

        TimeTools time = new TimeTools();
        MonthButtonHandler monthButtonHandler = new MonthButtonHandler();
        MonthTools monthTools = new MonthTools();

        HBox hBox = new HBox();
        hBox.setLayoutX(300);
        hBox.setLayoutY(70);
        hBox.setPrefHeight(30);
        hBox.setPrefWidth(400);
        hBox.setSpacing(100);
        hBox.setAlignment(Pos.CENTER);
        hBox.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 0.7;");

        Button previousMonth = new Button("<");
        previousMonth.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        previousMonth.setId("monthAndYearId");
        previousMonth.setOnMouseClicked(monthButtonHandler.previousEventHandler);
        hBox.getChildren().add(previousMonth);

        monthAndYear = new Label();
        monthAndYear.setText(MonthButtonHandler.getShowMonth() + ", " + time.getYearNow());
        monthAndYear.setId("monthAndYearId");
        MonthButtonHandler.setShowMonth(String.valueOf(monthTools.getMonthString(monthTools.getCurrentShownMonth(0))));
        monthAndYear.setText(MonthButtonHandler.getShowMonth() + ", " + MonthTools.getYear());
        hBox.getChildren().add(monthAndYear);

        Button nextMonth = new Button(">");
        nextMonth.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        nextMonth.setId("monthAndYearId");
        nextMonth.setOnMouseClicked(monthButtonHandler.nextEventHandler);
        hBox.getChildren().add(nextMonth);

        root.getChildren().add(hBox);

    }

}
