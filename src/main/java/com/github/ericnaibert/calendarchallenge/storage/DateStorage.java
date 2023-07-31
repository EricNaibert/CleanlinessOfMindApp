package com.github.ericnaibert.calendarchallenge.storage;

import com.github.ericnaibert.calendarchallenge.calendar.TimeTools;
import com.github.ericnaibert.calendarchallenge.calendar.month.MonthTools;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DateStorage {

    private static final int monthToWrite = LocalDate.now().getMonthValue();
    private static final List<Integer> dayListToWrite = Collections.singletonList(new TimeTools().getPositionToCheck());
    private static final int yearToWrite = LocalDate.now().getYear();
    private static String oldFileToWrite;

    public static void storeDate() {

        String pathSeparator = File.separator;
        String userHome = System.getProperty("user.home");

        TimeTools time = new TimeTools();
        MonthTools monthTools = new MonthTools();

        File fileToSave = new File(userHome + pathSeparator + "MindCleanlinessApp" + pathSeparator + "DayOnGrid.jcm");

        try {

            FileOutputStream fileOutputStream = new FileOutputStream(fileToSave);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);

            if(fileToSave.exists() && getOldFileToWrite() != null) {

                if(monthToWrite == DateReader.getMonthsFromFile().get(DateReader.getLastIndexFromDaysFromFile())) {

                    DateModifier.modifyDateToWrite();

                    dataOutputStream.writeBytes(DateModifier.getNewStringToWrite());
                    dataOutputStream.close();

                } else {
                    dataOutputStream.writeBytes(getOldFileToWrite() + monthToWrite + "=" + dayListToWrite + "/" + yearToWrite + "#");
                    dataOutputStream.close();
                }



            } else {
                dataOutputStream.writeBytes("#" + monthToWrite + "=" + dayListToWrite + "/" + yearToWrite + "#");
                dataOutputStream.close();
            }



        } catch (FileNotFoundException e) {
            System.out.println("Day-Month File Save / Exception: " + e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String getOldFileToWrite() {
        return oldFileToWrite;
    }

    public static void setOldFileToWrite(String oldFileToWrite) {
        DateStorage.oldFileToWrite = oldFileToWrite;
    }

}
