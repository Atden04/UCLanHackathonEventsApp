package com.atden04.uclan_events_app.models;

import javafx.util.converter.LocalDateStringConverter;

import java.time.LocalDate;

public class Event {
    private String name;
    private String imagePath;
    private LocalDate date;

    public Event(String name, String image, LocalDate date)
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

    public LocalDate getDate() { return this.date;}
}
