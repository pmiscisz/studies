package org.example;

import jakarta.jws.WebService;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebService(
        endpointInterface = "org.example.MyFirstSOAPInterface",
        serviceName = "MyFirstSOAPService",
        portName = "MyFirstSOAPPort"
)
public class MyFirstWS implements MyFirstSOAPInterface {
    @Override
    public String getHelloWorldAsString(String name) {
        return "Witaj " + name + "!";
    }

    @Override
    public long getDaysBetweenDates(String date1, String date2) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
        LocalDate d1 = LocalDate.parse(date1, dtf);
        LocalDate d2 = LocalDate.parse(date2, dtf);
        return Duration.between(d1.atStartOfDay(), d2.atStartOfDay()).toDays();
    }
}