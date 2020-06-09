package Visitor;


public class Meat implements iProducts {

    private double price;


    Meat(double price){ this.price = price; }

    public double calculate(iTax tax) {
        return tax.taxCalc(this);
    }

    //Getters/setters
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }


}
