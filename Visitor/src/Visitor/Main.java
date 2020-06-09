package Visitor;

public class Main {

    public static void main(String[] args) {
        iTax taxes = new Tax();

        Meat ribs = new Meat(50);
        Fruit apple = new Fruit(123.56);
        Alcohol rum = new Alcohol(123.6);


        //Första sout visar pris satt, andra visar priset med taxes(Kör metoden calculate i objectet som använder visitor för att visa taxes för specifik product).
        System.out.println("Price for ribs: "+ ribs.getPrice());
        System.out.println(ribs.calculate(taxes)+"\n");
        System.out.println("Price for apple: " +apple.getPrice());
        System.out.println(apple.calculate(taxes)+"\n");
        System.out.println("Price for rum: "+ rum.getPrice());
        System.out.println(rum.calculate(taxes)+"\n");


    }
}
