package Proxy;

public class Main {

    public static void main(String[] args){
        Proxy porxy = new Proxy();

        porxy.setNumber(1337);
        porxy.setText("This is text");
        porxy.print();

        Proxy proxy = new Proxy();

        proxy.setNumber(7331);
        proxy.setText("Hejsan ");
        proxy.print();
    }
}
