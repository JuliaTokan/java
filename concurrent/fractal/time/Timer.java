package time;

import java.time.format.DateTimeFormatter;
import java.time.*;

public class Timer implements Runnable {
    private String timeZone;

    public Timer(String timeZone) {
        this.timeZone = timeZone;
    }

    @Override
    public void run() {
        printTime(timeZone);
    }

    private void printTime(String timeZone){
        ZonedDateTime time;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        switch (timeZone) {
            case "Kiev":
                time = ZonedDateTime.now(ZoneId.of("Europe/Kiev"));
                System.out.println("Kiev "+time.format(formatter));
                break;
            case "Paris":
                time = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
                System.out.println("Paris "+time.format(formatter));
                break;
            case "New York":
                time = ZonedDateTime.now(ZoneId.of("America/New_York"));
                System.out.println("New York "+time.format(formatter));
                break;
            case "London":
                time = ZonedDateTime.now(ZoneId.of("Europe/London"));
                System.out.println("London "+time.format(formatter));
                break;
        }
    }
}
