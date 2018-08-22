package com.sprtster;

import com.sprtster.beans.CachedFileLogger;
import com.sprtster.beans.Client;
import com.sprtster.beans.Event;
import com.sprtster.beans.EventLogger;
import com.sprtster.beans.FileLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

/**
 * Hello world!
 */
public class App {
    Client client;
    EventLogger logger;

    public App() {
    }

    public App(Client client, EventLogger logger) {
        this.client = client;
        this.logger = logger;
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_context.xml");
        System.out.println("Hello World!");
        System.out.println();
        System.out.println("try to get off Client and logger beans!");
        System.out.println();

        Client client = applicationContext.getBean("client", Client.class);
        System.out.println(client.getName() + " client got success.");

        Event event = applicationContext.getBean("event", Event.class);
        System.out.println(event.toString() + " event got success.");

        FileLogger fileLogger = applicationContext.getBean("fileLogger", FileLogger.class);
        System.out.println(fileLogger.toString());

        CachedFileLogger cachedFileLogger = applicationContext.getBean(CachedFileLogger.class);

        Event event1 = new Event(new Date(), DateFormat.getDateInstance(2));
        Thread.sleep(1000);
        Event event2 = new Event(new Date(), DateFormat.getDateInstance(2));
        Thread.sleep(1000);
        Event event3 = new Event(new Date(), DateFormat.getDateInstance(2));
        Thread.sleep(1000);
        Event event4 = new Event(new Date(), DateFormat.getDateInstance(2));
        Thread.sleep(1000);
        Event event5 = new Event(new Date(), DateFormat.getDateInstance(2));
        Thread.sleep(1000);
        Event event6 = new Event(new Date(), DateFormat.getDateInstance(2));
        cachedFileLogger.logEvent(event);
        cachedFileLogger.logEvent(event1);
        cachedFileLogger.logEvent(event2);
        cachedFileLogger.logEvent(event3);
        cachedFileLogger.logEvent(event4);
        cachedFileLogger.logEvent(event5);
        cachedFileLogger.logEvent(event6);

        System.out.println(cachedFileLogger.toString() + " logger got successfully");
        cachedFileLogger.flushLogsToFile();
    }
}
