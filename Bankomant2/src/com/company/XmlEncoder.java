package com.company;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class XmlEncoder {


    //Method to save to XML.
    public static void  write(ArrayList<Account> aList) {
        try {

            XMLEncoder x = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("test.xml")));

            System.out.println("Printar till XML");

            x.writeObject(aList);
            x.close();



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Method to load from XML.
    public static List<Account> read() {
        List<Account> abist = new ArrayList<>();
        try {
        XMLDecoder c = new XMLDecoder(new BufferedInputStream(new FileInputStream("test.xml")));
            abist = (List<Account>) c.readObject();
            System.out.println("Kör decoder");
            c.close();

        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }catch(Exception e){
            System.out.println("Nånting gick fel.");
        }
            return abist;



    }


    private static class Person {
    }
}