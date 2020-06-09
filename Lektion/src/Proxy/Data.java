package Proxy;

public class Data {
    int number;
    String text;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public void print(){
        System.out.println(text);
        System.out.println(number);
    }
}
