package Visitor;

public class Fruit implements iProducts{

    private double price;

    Fruit(double price){ this.price = price; }

    public double calculate(iTax tax) {
        return tax.taxCalc(this);
    }

    //Getters/setters
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }


}
