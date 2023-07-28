package com.github.ericnaibert.calendarchallenge.calendar.month;

import com.github.ericnaibert.calendarchallenge.calendar.TimeTools;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

@SuppressWarnings("unused")
public class MonthButtonHandler extends CalendarMonthChanger{

    private static String showMonth;

    public EventHandler<MouseEvent> previousEventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {

            TimeTools time = new TimeTools();
            MonthTools monthTools = new MonthTools();
            setShowMonth(String.valueOf(monthTools.getMonthString(monthTools.getCurrentShownMonth(-1))));

            monthAndYear.setText(MonthButtonHandler.getShowMonth() + ", " + MonthTools.getYear());
        }
    };

    public EventHandler<MouseEvent> nextEventHandler = new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent event) {

            TimeTools time = new TimeTools();
            MonthTools monthTools = new MonthTools();

            setShowMonth(String.valueOf(monthTools.getMonthString(monthTools.getCurrentShownMonth(1))));

            monthAndYear.setText(MonthButtonHandler.getShowMonth() + ", " + MonthTools.getYear());
        }
    };

    public static String getShowMonth() {
        return showMonth;
    }

    public static void setShowMonth(String showMonth) {
        MonthButtonHandler.showMonth = showMonth;
    }

}
