package com.sabahtalateh.cards;

public class Model {
    int image;
    String title;

    public Model(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }
}
