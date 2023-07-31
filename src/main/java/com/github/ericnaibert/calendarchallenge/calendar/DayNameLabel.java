package com.github.ericnaibert.calendarchallenge.calendar;

import javafx.scene.control.Label;

public class DayNameLabel extends ApplicationCalendar {

    public static void dayNameLabel() {

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

    }

}
