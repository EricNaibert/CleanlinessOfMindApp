package com.github.ericnaibert.calendarchallenge.storage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateReader {

    private static final List<Integer> monthsFromFile = new ArrayList<>();
    private static final List<List<Integer>> daysFromFile = new ArrayList<>();
    private static final List<Integer> yearsFromFile = new ArrayList<>();

    public static void dayMonthReader() {

        String pathSeparator = File.separator;
        String userHome = System.getProperty("user.home");
        File fileToSave = new File(userHome + pathSeparator + "MindCleanlinessApp" + pathSeparator + "DayOnGrid.jcm");

        if(fileToSave.exists()) {

            try {
                FileInputStream fileInputStream = new FileInputStream(fileToSave);
                DataInputStream dataInputStream = new DataInputStream(fileInputStream);

                DateStorage.setOldFileToWrite(new String(dataInputStream.readAllBytes(), StandardCharsets.UTF_8));

                System.out.println("Full File String: " + DateStorage.getOldFileToWrite());

                Pattern monthPatter = Pattern.compile("#[1-9]=");
                Pattern daysPatter = Pattern.compile("\\[[1-9, ]{1,42}]");
                Pattern yearsPatter = Pattern.compile("/[0-9]{1,100}#");

                Matcher monthMatcher = monthPatter.matcher(DateStorage.getOldFileToWrite());
                Matcher daysMatcher = daysPatter.matcher(DateStorage.getOldFileToWrite());
                Matcher yearsMatcher = yearsPatter.matcher(DateStorage.getOldFileToWrite());

                while (monthMatcher.find()) {
                    monthsFromFile.add(cleanToInteger(monthMatcher.group()));
                }

                while (daysMatcher.find()) {
                    daysFromFile.add(cleanIntegerList(daysMatcher));
                }

                while (yearsMatcher.find()) {
                    yearsFromFile.add(cleanToInteger(yearsMatcher.group()));
                }

                System.out.println("ONLY MONTHS: " + monthsFromFile);
                System.out.println("ONLY DAYS: " + daysFromFile);
                System.out.println("ONLY YEARS: " + yearsFromFile);

                dataInputStream.close();

            } catch (FileNotFoundException e) {
                System.out.println("Day-Month File Reader / Exception: " + e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }

    public static Integer cleanToInteger(String stringToConvert) {

        return Integer.valueOf(stringToConvert.replace("[", "").replace("]", "").
                replace("#", "").replace("=", "").replace("/", "").
                replace(",", ""));

    }

    public static List<Integer> cleanIntegerList(Matcher matcher) {

        String[] tempList = matcher.group().replace("[", "").replace("]", "").
                replace(" ", "").split(",");
        List<Integer> tempIntegerList = new ArrayList<>();

        for (String s : tempList) {
            tempIntegerList.add(Integer.valueOf(s));
        }

        return tempIntegerList;
    }

    public static List<Integer> getMonthsFromFile() {
        return monthsFromFile;
    }

    public static List<Integer> getDaysFromMonth(int month) {
        return daysFromFile.get(month);
    }

    public static List<Integer> getYearsFromFile() {
        return yearsFromFile;
    }

    public static int getLastIndexFromDaysFromFile() {
        return daysFromFile.size()-1;
    }

}


