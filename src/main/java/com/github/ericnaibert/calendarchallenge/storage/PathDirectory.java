package com.github.ericnaibert.calendarchallenge.storage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PathDirectory {

    private static final String userHome = System.getProperty("user.home");
    private final File fileToSave = new File(userHome + File.separator + "MindCleanlinessApp" + File.separator + "DayOnGrid.jcm");

    public static void createPathDirectory() {

        String pathSeparator = File.separator;

        try {
            Path path = Path.of(userHome + pathSeparator + "MindCleanlinessApp");
            Files.createDirectories(path);

        } catch (IOException e) {
            System.out.println("Storage / Exception: " + e);
        }

    }

    public File getFileToSave() {
        return fileToSave;
    }
}
