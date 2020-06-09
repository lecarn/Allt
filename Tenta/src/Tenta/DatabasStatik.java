package Tenta;

import java.io.*;

public class DatabasStatik {

    String name;
    int artikelNr;
    int price;

    DatabasStatik(String name, int artikelNr, int price){
        this.name = name;
        this.artikelNr = artikelNr;
        this.price = price;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getArtikelNr() { return artikelNr; }
    public void setArtikelNr(int artikelNr) { this.artikelNr = artikelNr; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    @Override
    public String toString() {
        return "DatabasStatik{" +
                "name='" + name + '\'' +
                ", artikelNr=" + artikelNr +
                ", price=" + price +
                '}';
    }

}
