package sample;

import javafx.application.Platform;
import javafx.scene.control.TextField;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Tid {

    Boolean again = true;
    LocalTime timerNow = LocalTime.of(00, 00, 00, 00);
    DateTimeFormatter timerFormat = DateTimeFormatter.ofPattern("mm:ss:SSS");
    LocalTime firstTimeMeasure = LocalTime.now();
    LocalTime secondTimeMeasure = LocalTime.now();
    public void setAgain(boolean ny){again =ny;}
    public String getTimer(){return timerFormat.format(timerNow).toString();}
    public void setTimer(LocalTime newtime){ timerNow=newtime;}

    /*
Kör Timern genom en Tråd som skapas i en funktion innanför controller klassen, tråden kan köras
flera gånger för att den ligger inom en funktion
*/
    public void timer(TextField Tiden) throws Exception{
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (again) {
                    /////Switchar till nuvarande GUI tråden detta är jätteviktigt annars krashar tråden
                    Platform.runLater(() ->
                    {
                        Tiden.setText(timerFormat.format(timerNow));
                    });
                    firstTimeMeasure = LocalTime.now();
                    try {
                        TimeUnit.MILLISECONDS.sleep(5);
                        secondTimeMeasure = LocalTime.now();
                        long e = Duration.between(firstTimeMeasure, secondTimeMeasure).toMillis();
                        timerNow = timerNow.plusNanos(e * 1000000);
                        //////// Using 3 time objects 2 for measuring time.now() and measuring diffrence between them
                        /////converting nanoseconds to milliseconds and adding that to the third time object that will
                        ////representing the timer
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
    }
////////////////End Thread
}

