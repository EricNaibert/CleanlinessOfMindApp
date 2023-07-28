package com.github.ericnaibert.calendarchallenge.storage;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class CheckNodes {

    private static final ArrayList<ImageView> checkList = new ArrayList<>();

    public static void addToCheckList(ImageView node) {
        CheckNodes.checkList.add(node);
    }

    public static ArrayList<ImageView> getCheckList() {
       return CheckNodes.checkList;
    }
}
