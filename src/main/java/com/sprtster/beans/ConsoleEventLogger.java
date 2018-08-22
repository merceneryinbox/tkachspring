package com.sprtster.beans;

import lombok.Data;

@Data
public class ConsoleEventLogger implements EventLogger {
    String name = "logger1";

    @Override
    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
