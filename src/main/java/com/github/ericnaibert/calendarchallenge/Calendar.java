package com.github.ericnaibert.calendarchallenge;

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

            vBoxList.get(j+firstDayOfMonth).getChildren().add(new Label(String.valueOf(j+1)));
        }

        int x = 80;

        for(int i = 0; i < 7; i++) {
            Label dayNameLabel = new Label();
            switch (i) {
                case 0 -> dayNameLabel.setText("Domingo");
                case 1 -> dayNameLabel.setText("Segunda");
                case 2 -> dayNameLabel.setText("Terça");
                case 3 -> dayNameLabel.setText("Quarta");
                case 4 -> dayNameLabel.setText("Quinta");
                case 5 -> dayNameLabel.setText("Sexta");
                case 6 -> dayNameLabel.setText("Sábado");
            }
            dayNameLabel.setId("dayNameLabelId");
            dayNameLabel.setLayoutY(120);
            dayNameLabel.setLayoutX(x);
            root.getChildren().add(dayNameLabel);
            x += 130;
        }

        root.getChildren().add(flowPane);

    }

}
