package com.github.ericnaibert.calendarchallenge.calendar;

import java.time.LocalDate;

public class TimeTools {

    private final int monthNow = LocalDate.now().getMonthValue();
    private final int yearNow = LocalDate.now().getYear();
    private final int dayNow = LocalDate.now().getDayOfMonth();
    private final int lengthOfMonth = LocalDate.now().lengthOfMonth();
    private final int firstDayOfMonth = LocalDate.of(yearNow, monthNow, 1).getDayOfWeek().getValue();

    public int getMonthNow() {
        return monthNow;
    }

    public int getYearNow() {
        return yearNow;
    }

    public int getDayNow() {
        return dayNow;
    }

    public int getLengthOfMonth() {
        return lengthOfMonth;
    }

    public int getFirstDayOfMonth() {
        return firstDayOfMonth;
    }
}
