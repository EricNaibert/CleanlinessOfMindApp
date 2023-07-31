package com.github.ericnaibert.calendarchallenge.calendar.month;

import com.github.ericnaibert.calendarchallenge.ApplicationInterface;
import com.github.ericnaibert.calendarchallenge.calendar.CheckDayButton;
import com.github.ericnaibert.calendarchallenge.calendar.CheckDayOld;
import com.github.ericnaibert.calendarchallenge.calendar.TimeTools;
import com.github.ericnaibert.calendarchallenge.storage.DateReader;
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

    protected static Label monthAndYearLabel;

    public static void monthProperties() {

        TimeTools time = new TimeTools();
        MonthTools monthTools = new MonthTools();
        MonthButtonHandler monthButtonHandler = new MonthButtonHandler();

        DateReader.dayMonthReader();

        HBox hBox = new HBox();
        hBox.setLayoutX(300);
        hBox.setLayoutY(70);
        hBox.setPrefHeight(30);
        hBox.setPrefWidth(400);
        hBox.setSpacing(50);
        hBox.setAlignment(Pos.CENTER);
        hBox.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 0.7;");

        Button previousMonth = new Button("<");
        previousMonth.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        previousMonth.setId("monthAndYearId");
        previousMonth.setOnMouseClicked(monthButtonHandler.previousEventHandler);
        hBox.getChildren().add(previousMonth);

        monthAndYearLabel = new Label();
        monthAndYearLabel.setText(MonthButtonHandler.getShowMonth() + ", " + time.getYearNow());
        monthAndYearLabel.setId("monthAndYearId");
        monthAndYearLabel.setAlignment(Pos.CENTER);
        monthAndYearLabel.setPrefWidth(400);

        MonthButtonHandler.setShowMonth(String.valueOf(monthTools.getMonthString(monthTools.monthScannerDirectionToGo(0))));
        monthAndYearLabel.setText(MonthButtonHandler.getShowMonth() + ", " + MonthTools.getYear());

        hBox.getChildren().add(monthAndYearLabel);

        Button nextMonth = new Button(">");
        nextMonth.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        nextMonth.setId("monthAndYearId");
        nextMonth.setOnMouseClicked(monthButtonHandler.nextEventHandler);
        hBox.getChildren().add(nextMonth);

        CheckDayOld.checkOldDays(monthTools.getIndexIfMonthExist());

        CheckDayButton.addCheckButton();

        root.getChildren().add(hBox);

    }

}
