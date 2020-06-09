package Tenta;


import java.io.IOException;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) throws IOException {
        double price = 0;
        Choices chooser = new Choices();

        while(true) {
            DatabasStatik ds = chooser.getArtikelNr();
            System.out.println(ds.toString());
            price = chooser.getMultiplePrice(ds) + price;

        }
    }
}