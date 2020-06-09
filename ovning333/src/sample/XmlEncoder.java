package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XmlEncoder {


    //Method to save to XML.
    public static void  write(ArrayList<Person> aList) {
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
    public static List<Person> read() throws FileNotFoundException {
        XMLDecoder c = new XMLDecoder(new BufferedInputStream(new FileInputStream("test.xml")));

        List<Person> abist = new ArrayList<>();
//        Person result = (Person) c.readObject();
        abist = (List<Person>) c.readObject();
//        abist.add(result);
        System.out.println("Kör decoder");
//        ObservableList<Person> obListt = FXCollections.observableArrayList();

//        obListt.addAll(abist);
        c.close();
        return abist;


    }


}