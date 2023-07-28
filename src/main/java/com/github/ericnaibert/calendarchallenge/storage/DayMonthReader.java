package com.github.ericnaibert.calendarchallenge.storage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class DayMonthReader {

    private static final List<Integer> readedDays = new ArrayList<>();
    private static Integer readedMonth;

    public static void dayMonthReader() {

        String pathSeparator = File.separator;
        String userHome = System.getProperty("user.home");
        File fileToSave = new File(userHome + pathSeparator + "MindCleanlinessApp" + pathSeparator + "DayOnGrid.jcm");

        if(fileToSave.exists()) {

            try {
                FileInputStream fileInputStream = new FileInputStream(fileToSave);
                DataInputStream dataInputStream = new DataInputStream(fileInputStream);

                String fileContent = new String(dataInputStream.readAllBytes(), StandardCharsets.UTF_8);
                String[] fileContentSplit = fileContent.split("=");
                String[] numbers = fileContentSplit[1].replaceAll("[^,0123456789]","").split(",");

                for (String i: numbers) {
                    readedDays.add(Integer.valueOf(i));
                }
                readedMonth = Integer.valueOf(fileContentSplit[0].replace("[", ""));

                dataInputStream.close();

            } catch (FileNotFoundException e) {
                System.out.println("Day-Month File Reader / Exception: " + e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }

    public static List<Integer> getReadedDays() {
        return readedDays;
    }

    public static Integer getReadedMonth() {
        return readedMonth;
    }
}
