package com.atden04.uclan_events_app.models;

public class Event {
    private String name;
    private String imagePath;

    public Event(String name, String image)
    {
        this.name = name;
        this.imagePath = image;
    }

    public String getName() {
        return this.name;
    }

    public String getImagePath()
    {
        return this.imagePath;
    }
}
