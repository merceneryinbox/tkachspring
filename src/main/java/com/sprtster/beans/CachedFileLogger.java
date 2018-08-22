package com.sprtster.beans;

import javax.annotation.PreDestroy;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CachedFileLogger extends FileLogger {
    private String fileName;
    private File file;
    private Integer cacheSize;
    private List<Event> cacheList;

    public CachedFileLogger(Integer cacheSize, String fileName) {
        super(fileName);
        this.cacheSize = cacheSize;
        this.cacheList = new ArrayList<>(cacheSize);

    }

    @Override
    public void logEvent(Event event) throws IOException {
        if (cacheList.size() >= cacheSize) {
            flushLogsToFile();
        } else {
            cacheList.add(event);
        }
    }

    public void flushLogsToFile() throws IOException {
        for (Event event : cacheList) {
            System.out.println(event.toString());
            writeEventToFile(event);
        }
        cacheList.clear();
    }

    @PreDestroy
    private void flushOnExit() throws IOException {
        flushLogsToFile();
    }
}
