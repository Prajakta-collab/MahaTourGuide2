package com.example.mahatourguide;

public class Place {

    private String name;
    private String shortDescription;
    private String description;
    private int imageResourceId;

    public Place(String name, String shortDescription, String description, int imageResourceId) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
