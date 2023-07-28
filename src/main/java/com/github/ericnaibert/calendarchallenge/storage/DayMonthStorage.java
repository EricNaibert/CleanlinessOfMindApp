package com.github.ericnaibert.calendarchallenge.storage;

import com.github.ericnaibert.calendarchallenge.calendar.TimeTools;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class DayMonthStorage {

    public static void dayMonthStorage() {

        String pathSeparator = File.separator;
        String userHome = System.getProperty("user.home");

        TimeTools time = new TimeTools();

        File fileToSave = new File(userHome + pathSeparator + "MindCleanlinessApp" + pathSeparator + "DayOnGrid.jcm");

        try {

            FileOutputStream fileOutputStream = new FileOutputStream(fileToSave);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);

            Map<Integer, List<Integer>> positionsToWrite = new HashMap<>();

            List<Integer> daysList = new ArrayList<>();

            if(fileToSave.exists() && DayMonthReader.getReadedMonth() != null) {

                DayMonthReader.getReadedDays().add(time.getPositionToCheck());
                positionsToWrite.put(DayMonthReader.getReadedMonth(), DayMonthReader.getReadedDays());
            } else {

                daysList.add(time.getPositionToCheck());
                positionsToWrite.put(time.getMonthNow(), daysList);
            }

            System.out.println(time.getPositionToCheck());
            dataOutputStream.writeBytes(positionsToWrite.entrySet().toString());
            dataOutputStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("Day-Month File Save / Exception: " + e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
