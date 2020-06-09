package sample;

public class Log {

    public Log(){

    }       /* Logs output in console. (confirming buttons presses) */

    public void reset(){
        System.out.println("- Clock reset");
    }
    public void start(){
        System.out.println("- Clock started");
    }
    public void stop(){
        System.out.println("- Clock stopped");
    }
    public void clear(){
        System.out.println("- History cleared");
    }
    public void save() {
        System.out.println("- Time saved to history");
    }
}
