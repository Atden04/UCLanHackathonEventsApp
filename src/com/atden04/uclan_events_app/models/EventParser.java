package com.atden04.uclan_events_app.models;

import javafx.collections.ObservableList;
import javafx.util.converter.LocalDateStringConverter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

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

                LocalDateStringConverter converter = new LocalDateStringConverter();
                LocalDate date = converter.fromString(values[2]);

                events.addLast(new Event(values[0], values[1], date));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
