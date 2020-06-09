package sample;

public class Timercalc {

    private int ms, s, m, tempMs, tempS;
    private int msSplit, sSplit, mSplit, tempMsSplit, tempSSplit;
    private String newTime, newSplitTime;

    public Timercalc() {
    }

    /* Method for calculating seconds and minutes from current value of millis-counter*/
    public String calc(int millis){

        ms = millis;

        s = ms/1000;
        m = ms/60000;
        tempMs = ms%1000;
        tempS = s%60;

        /* Adding new values to string with format (m:s:ms) */
        newTime = String.format("%02d:%02d:%03d", m, tempS, tempMs);
        return(newTime);
    }

    /* - (Split time) */
    public String calcSplitTime(int millisSplit){

        msSplit = millisSplit;

        sSplit = msSplit /1000;
        mSplit = msSplit /60000;
        tempMsSplit = msSplit %1000;
        tempSSplit = sSplit %60;

        newSplitTime = String.format("%02d:%02d:%03d", mSplit, tempSSplit, tempMsSplit);
        return(newSplitTime);
    }
}
