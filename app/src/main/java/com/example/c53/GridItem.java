package com.example.c53;

import java.util.ArrayList;
import java.util.List;

public class GridItem {

    private int imageResource;
    private String text;

    public GridItem(int imageResource, String text) {
        this.imageResource = imageResource;
        this.text = text;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getText() {
        return text;
    }


}
