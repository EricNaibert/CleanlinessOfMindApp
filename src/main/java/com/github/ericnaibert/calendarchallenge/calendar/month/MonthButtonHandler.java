package com.github.ericnaibert.calendarchallenge.calendar.month;

import com.github.ericnaibert.calendarchallenge.calendar.TimeTools;
import com.github.ericnaibert.calendarchallenge.storage.DateReader;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

@SuppressWarnings("unused")
public class MonthButtonHandler extends CalendarMonthChanger{

    private static String showMonth;

    private static int currentFileMonth;

    public EventHandler<MouseEvent> previousEventHandler = event -> {

        TimeTools time = new TimeTools();
        MonthTools monthTools = new MonthTools();

        setShowMonth(monthTools.getMonthString(monthTools.monthScannerDirectionToGo(-1)));
        monthAndYearLabel.setText(getShowMonth() + ", " + MonthTools.getYear());

        if(monthTools.getIndexIfMonthExist() != 404) {
           System.out.println("HAS PREVIOUS");
           System.out.println(DateReader.getMonthsFromFile().get(monthTools.getIndexIfMonthExist()));
        }

    };

    public EventHandler<MouseEvent> nextEventHandler = event -> {

        TimeTools time = new TimeTools();
        MonthTools monthTools = new MonthTools();

        setShowMonth(monthTools.getMonthString(monthTools.monthScannerDirectionToGo(1)));
        monthAndYearLabel.setText(getShowMonth() + ", " + MonthTools.getYear());

        if(monthTools.getIndexIfMonthExist() != 404) {
            System.out.println("HAS NEXT");
            System.out.println(DateReader.getMonthsFromFile().get(monthTools.getIndexIfMonthExist()));
        }

    };

    public static String getShowMonth() {
        return showMonth;
    }

    public static void setShowMonth(String showMonth) {
        MonthButtonHandler.showMonth = showMonth;
    }

    public static int getCurrentFileMonth() {
        return currentFileMonth;
    }

    public static void setCurrentFileMonth(int currentFileMonth) {
        MonthButtonHandler.currentFileMonth = currentFileMonth;
    }
}
