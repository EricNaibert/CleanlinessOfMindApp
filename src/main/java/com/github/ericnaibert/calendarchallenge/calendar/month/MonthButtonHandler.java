package com.github.ericnaibert.calendarchallenge.calendar.month;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

@SuppressWarnings("unused")
public class MonthButtonHandler {

    public EventHandler<MouseEvent> previousEventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            System.out.println("Previous Month Button Clicked!");
        }
    };

    public EventHandler<MouseEvent> nextEventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            System.out.println("Next Month Button Clicked!");
        }
    };

}
