package openlogfile;

public class OpenLogFile{
    private int times;

    private static OpenLogFile oneAndOnly = new OpenLogFile();

    public static OpenLogFile getInstance() {
        return oneAndOnly;
    }
    private OpenLogFile(){
        times = 0;
    }
    public int getTimes(){
        System.out.println(times);
        return times++;
    }

}
