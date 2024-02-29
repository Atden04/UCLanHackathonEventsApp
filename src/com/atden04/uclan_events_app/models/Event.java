package com.atden04.uclan_events_app.models;

public class Event {
    private String name;
    private String imagePath;
    private String date;

    public Event(String name, String image, String date)
    {
        this.name = name;
        this.imagePath = image;
        this.date = date;
    }

    public String getName() {
        return this.name;
    }

    public String getImagePath()
    {
        return this.imagePath;
    }
}
