package com.github.ericnaibert.calendarchallenge.storage;

import com.github.ericnaibert.calendarchallenge.calendar.TimeTools;

import java.util.ArrayList;
import java.util.List;

public class DateModifier {

    private static final List<Integer> newDayListToWrite = new ArrayList<>();

    private static String newStringToWrite = "";

    public static void modifyDateToWrite() {

        TimeTools time = new TimeTools();

        newDayListToWrite.addAll(DateReader.getDaysFromMonth(DateReader.getLastIndexFromDaysFromFile()));
        newDayListToWrite.add(time.getPositionToCheck());

        System.out.println(DateReader.getMonthsFromFile().size());

        for(int i = 0; i < DateReader.getMonthsFromFile().size(); i++) {

            if(i == DateReader.getMonthsFromFile().size() -1) {
                newStringToWrite = newStringToWrite.concat("#" + DateReader.getMonthsFromFile().get(i) + "=" +
                        newDayListToWrite + "/" + DateReader.getYearsFromFile().get(i) + "#");
            } else {
                newStringToWrite = newStringToWrite.concat("#" + DateReader.getMonthsFromFile().get(i) + "=" +
                        DateReader.getDaysFromMonth(i) + "/" + DateReader.getYearsFromFile().get(i) + "#");
            }

        }

        System.out.println("New to Write: " + newStringToWrite);
    }

    public static String getNewStringToWrite() {
        return newStringToWrite;
    }

}
