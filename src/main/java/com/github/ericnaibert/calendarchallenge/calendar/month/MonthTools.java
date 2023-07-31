package com.github.ericnaibert.calendarchallenge.calendar.month;


import com.github.ericnaibert.calendarchallenge.storage.DateReader;

import java.time.LocalDate;

public class MonthTools {

    protected static int[] monthArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    private static int arrayScanner = LocalDate.now().getMonthValue() -1;

    private static Integer year = LocalDate.now().getYear();

    public String getMonthString(int monthNumber) {

        return switch (monthNumber) {

            case 1 -> "JANUARY";
            case 2 -> "FEBRUARY";
            case 3 -> "MARCH";
            case 4 -> "APRIL";
            case 5 -> "MAY";
            case 6 -> "JUNE";
            case 7 -> "JULY";
            case 8 -> "AUGUST";
            case 9 -> "SEPTEMBER";
            case 10 -> "OCTOBER";
            case 11 -> "NOVEMBER";
            case 12 -> "DECEMBER";
            default -> throw new IllegalStateException("Unexpected value: " + monthNumber);

        };
    }

    public int monthScannerDirectionToGo(int direction) {

        if(direction == 0) {
            return monthArray[arrayScanner];

        } else

        if(direction == 1) {

            if(arrayScanner > 10) {
                arrayScanner = 0;
                year = year + 1;

            } else {
                arrayScanner = arrayScanner + 1;
            }

            return monthArray[arrayScanner];

        } else

        if(direction == -1) {

            if(arrayScanner < 1) {
                arrayScanner = 11;
                year = year - 1;

            } else {
                arrayScanner = arrayScanner - 1;
            }

            return monthArray[arrayScanner];

        } else {

            return 404;
        }
    }

    public int monthScannerCurrentIndex() {
        return monthArray[arrayScanner];
    }

    public int getIndexIfMonthExist() {

        if(DateReader.getMonthsFromFile().contains(arrayScanner+1)) {
            return DateReader.getMonthsFromFile().indexOf(arrayScanner+1);
        } else {
            return 404;
        }
    }

    public static Integer getYear() {
        return year;
    }
}
