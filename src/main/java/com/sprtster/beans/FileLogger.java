package com.sprtster.beans;

import lombok.Data;
import org.apache.commons.io.FileUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Data
public class FileLogger implements EventLogger {
    private String fileName;
    private File file;

    public FileLogger(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void logEvent(Event event) throws IOException {
        writeEventToFile(event);
    }

    public void writeEventToFile(Event event) throws IOException {
        FileUtils.writeStringToFile(new File(fileName), "\n" + event.toString() + "\n", true);
    }

    @PostConstruct
    private void initFileAccessCheck() throws IOException {
        this.file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        if (!file.canWrite()) {
            throw new IOException("You just can't use logfile !");
//            System.out.println("You just can't use logfile !");
        } else {
            System.out.println("File Created and accessed");
            FileUtils.writeStringToFile(file,
                                        "\n-------------------------------------------------------------------------------\n" +
                                        (new Date()).toString() +
                                        "\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n",
                                        StandardCharsets.UTF_8,
                                        true);
        }
    }
}
