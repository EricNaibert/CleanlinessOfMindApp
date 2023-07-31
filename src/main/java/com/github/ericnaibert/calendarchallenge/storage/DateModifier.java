package com.github.ericnaibert.calendarchallenge.storage;

import com.github.ericnaibert.calendarchallenge.calendar.TimeTools;
import com.github.ericnaibert.calendarchallenge.calendar.month.MonthTools;

import java.util.ArrayList;
import java.util.List;

public class DateModifier {

    private static final List<Integer> newDayListToWrite = new ArrayList<>();

    private static String newStringToWrite = "";

    public static void modifyDateToWrite() {

        TimeTools time = new TimeTools();
        MonthTools monthTools = new MonthTools();

        newDayListToWrite.addAll(DateReader.getDaysFromMonth(DateReader.getLastIndexFromDaysFromFile()));
        newDayListToWrite.add(time.getPositionToCheck());

        for(int i = 0; i < DateReader.getMonthsFromFile().size(); i++) {

            if(i == DateReader.getMonthsFromFile().size() -1) {
                newStringToWrite = newStringToWrite.concat("#" + DateReader.getMonthsFromFile().get(i) + "=" +
                        newDayListToWrite + "/" + DateReader.getYearsFromFile().get(i) + "#");
            } else {
                newStringToWrite = newStringToWrite.concat("#" + DateReader.getMonthsFromFile().get(i) + "=" +
                        DateReader.getDaysFromMonth(i) + "/" + DateReader.getYearsFromFile().get(i) + "#");
            }

        }

        System.out.println(newStringToWrite);
    }

    public static String getNewStringToWrite() {
        return newStringToWrite;
    }

}
