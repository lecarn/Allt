package sample;

public class Counter {

    int counterA= 1;
    int counterB= 1;

    public Counter(){}

    public int getCounterA() { return counterA; }
    public void setCounterA(int counterA) { this.counterA = counterA; }
    public int getCounterB() { return counterB; }
    public void setCounterB(int counterB) { this.counterB = counterB; }

    public int countA(){
        return counterA++;
    }
    public int countB(){
        return counterB++;
    }
}
