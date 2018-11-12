package time;

import java.util.concurrent.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ScheduledExecutorService timeKiev =
                Executors.newScheduledThreadPool(2);
        ScheduledExecutorService timeParis =
                Executors.newScheduledThreadPool(2);
        ScheduledExecutorService timeLondon =
                Executors.newScheduledThreadPool(2);
        ScheduledExecutorService timeNewYork =
                Executors.newScheduledThreadPool(2);

        Timer timerKiev = new Timer("Kiev");
        Timer timerParis = new Timer("Paris");
        Timer timerLondon = new Timer("London");
        Timer timerNewYork = new Timer("New York");

        Scanner scanner = new Scanner(System.in);
        do
            {
            timeKiev.scheduleAtFixedRate(timerKiev, 1, 1, TimeUnit.SECONDS);
            timeParis.scheduleAtFixedRate(timerParis, 1, 5, TimeUnit.SECONDS);
            timeLondon.scheduleAtFixedRate(timerLondon, 1, 5, TimeUnit.SECONDS);
            timeNewYork.scheduleAtFixedRate(timerNewYork, 1, 5, TimeUnit.SECONDS);
        }
        while ((scanner.nextLine()).length() > 0);
        timeKiev.shutdown();
        timeParis.shutdown();
        timeLondon.shutdown();
        timeNewYork.shutdown();
    }
}
