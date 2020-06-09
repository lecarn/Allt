package Tenta;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Choices {
    FakeData fakeData = new FakeData();
    List<DatabasStatik> FakeDatabas;
    DatabasStatik ds;
    Scanner scn = new Scanner(System.in);

    Choices() {
    }

    public DatabasStatik getArtikelNr() {
        FakeDatabas = fakeData.getDatabas();
        int artikelNr;

        System.out.println("What article number do you want?");
        artikelNr = scn.nextInt();

        for (DatabasStatik ds : FakeDatabas) {
            if (ds.getArtikelNr() == artikelNr) {
                this.ds = ds;
                System.out.println("Returnarn "+ ds.getName());
                return ds;
            }
        }
        System.out.println("ArtikelNr didnt exist.");
        getArtikelNr();
        return ds;
    }


    public double getMultiplePrice(DatabasStatik ds) throws IOException {

        System.out.println("How many do you want to buy for: "+ds.getPrice());
        int count = scn.nextInt();
        double price = count * ds.getPrice();

        System.out.println(price);
        System.out.println("Would you like to buy more stuff? Y/N");

        String continueString = scn.next();
        if(continueString.charAt(0) == 'y' || continueString.charAt(0) == 'Y'){
            fakeData.printToDatabas(ds, count, price);
            getArtikelNr();
        }else{

            fakeData.printToDatabas(ds, count, price);
            System.exit(0);
        }
        return price;
    }
}

