package com.github.ericnaibert.calendarchallenge.calendar;

import com.github.ericnaibert.calendarchallenge.storage.DayMonthReader;

import java.time.LocalDate;
import java.util.List;

public class TimeTools {

    private final int monthNow = LocalDate.now().getMonthValue();
    private final int monthOld = LocalDate.now().minusMonths(1).getMonthValue();
    private final int monthNext = LocalDate.now().plusMonths(1).getMonthValue();
    private final int yearNow = LocalDate.now().getYear();
    private final int dayNow = LocalDate.now().getDayOfMonth();
    private final int lengthOfMonth = LocalDate.now().lengthOfMonth();
    private final List<Integer> olderPositions = DayMonthReader.getReadedDays().stream().toList();
    private final int firstDayOfMonth = LocalDate.of(getYearNow(), getMonthNow(), 1).getDayOfWeek().getValue();
    private final int positionToCheck = getDayNow() + getFirstDayOfMonth() -1;

    public int getMonthNow() {
        return monthNow;
    }

    public int getMonthOld() {
        return monthOld;
    }

    public int getMonthNext() {
        return monthNext;
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

    public int getPositionToCheck() {
        return positionToCheck;
    }

    public List<Integer> getOlderPositions() {
        return olderPositions;
    }
}
