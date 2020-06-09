package Visitor;

import java.sql.SQLOutput;
import java.text.DecimalFormat;

public class Tax implements iTax{

    //visitorn.
    DecimalFormat df = new DecimalFormat("#.##");

    //constructor för göra taxes(skulle i detta fall även kunna göras med static)
    public Tax(){}


    //metoder för räkna taxes beroende på vilket object som läggs in.
    public double taxCalc(Meat meat) {
        System.out.println("Doing taxCalc on meat");
        System.out.print("Price with taxes: ");
        return Double.parseDouble(df.format(meat.getPrice() * 1.40));
    }


    public double taxCalc(Fruit fruit) {
        System.out.println("Doing taxCalc on fruit");
        System.out.print("Price with taxes: ");
        return Double.parseDouble(df.format(fruit.getPrice() * 1.13));
    }


    public double taxCalc(Alcohol alcohol) {
        System.out.println("Doing taxCalc on alcohol");
        System.out.print("Price with taxes: ");
        return Double.parseDouble(df.format(alcohol.getPrice() * 2.50));
    }
}
