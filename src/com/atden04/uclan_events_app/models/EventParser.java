package com.atden04.uclan_events_app.models;

import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EventParser {
    /**
     * Parser from https://www.baeldung.com/java-csv-file-array
     * @param fileName
     * @param events
     */
    public void parseEvents(String fileName, ObservableList<Event> events) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                events.addLast(new Event(values[0], values[1], values[2]));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
