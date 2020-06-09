package sample;

public class Time {

    private String date;
    private String time;
    private String timerTime;

    public Time(){

    }

    /* Constructor (Used for observable list) */
    public Time(String date, String time, String timerTime){
        this.date = date;
        this.time = time;
        this.timerTime = timerTime;
    }

    public String getDate(){
        return date;
    }

    public String getTime(){
        return time;
    }

    public String getTimerTime(){
        return timerTime;
    }
}
