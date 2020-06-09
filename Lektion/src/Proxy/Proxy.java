package Proxy;


public class Proxy {

    Data d = new Data();

    public int getNumber() {
        return d.getNumber();
    }

    public void setNumber(int number) {
        d.setNumber(number);
    }

    public String getText() {
        return d.getText();
    }

    public void setText(String text) {
        d.setText(text);
    }
    public void print(){
        d.print();
    }
}
