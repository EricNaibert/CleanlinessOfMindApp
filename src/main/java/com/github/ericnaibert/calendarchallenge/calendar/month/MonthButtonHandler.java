package com.github.ericnaibert.calendarchallenge.calendar.month;

import com.github.ericnaibert.calendarchallenge.calendar.Calendar;
import com.github.ericnaibert.calendarchallenge.calendar.CheckDayButton;
import com.github.ericnaibert.calendarchallenge.calendar.CheckDayOld;
import com.github.ericnaibert.calendarchallenge.calendar.TimeTools;
import com.github.ericnaibert.calendarchallenge.storage.CheckNodes;
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

            if(MonthTools.getArrayScanner() + 1 == DayMonthReader.getReadedMonth()) {

                for(int i = 0; i < Calendar.vBoxList.size(); i++) {
                    Calendar.vBoxList.get(i).getChildren().removeAll(CheckNodes.getCheckList());
                }

                CheckDayOld.checkOldDays(time.getMonthNow());
                CheckDayButton.addCheckButton();

            } else {
                for(int i = 0; i < Calendar.vBoxList.size(); i++) {
                    Calendar.vBoxList.get(i).getChildren().removeAll(CheckNodes.getCheckList());
                }
                //CheckDayOld.checkOldDays(time.getMonthOld());
                root.getChildren().remove(CheckDayButton.getButton());
            }

            System.out.println(MonthTools.getArrayScanner());
        }
    };

    public EventHandler<MouseEvent> nextEventHandler = new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent event) {

            TimeTools time = new TimeTools();
            MonthTools monthTools = new MonthTools();

            setShowMonth(String.valueOf(monthTools.getMonthString(monthTools.getCurrentShownMonth(1))));

            monthAndYear.setText(MonthButtonHandler.getShowMonth() + ", " + MonthTools.getYear());

            if(MonthTools.getArrayScanner() + 1 == DayMonthReader.getReadedMonth()) {

                for(int i = 0; i < Calendar.vBoxList.size(); i++) {
                    Calendar.vBoxList.get(i).getChildren().removeAll(CheckNodes.getCheckList());
                }

                CheckDayOld.checkOldDays(time.getMonthNow());
                CheckDayButton.addCheckButton();

            } else {
                for(int i = 0; i < Calendar.vBoxList.size(); i++) {
                    Calendar.vBoxList.get(i).getChildren().removeAll(CheckNodes.getCheckList());
                }
                //CheckDayOld.checkOldDays(time.getMonthNext());
                root.getChildren().remove(CheckDayButton.getButton());
            }
        }
    };

    public static String getShowMonth() {
        return showMonth;
    }

    public static void setShowMonth(String showMonth) {
        MonthButtonHandler.showMonth = showMonth;
    }

}
