package com.github.ericnaibert.calendarchallenge;

import com.github.ericnaibert.calendarchallenge.storage.PathDirectory;

public class Main {

    public static void main(String [] args) {

        PathDirectory.createPathDirectory();
        ApplicationInterface.init(args);
    }

}