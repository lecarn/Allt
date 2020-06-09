package Visitor;

public interface iTax {

    public double taxCalc(Meat meat);
    public double taxCalc(Fruit fruit);
    public double taxCalc(Alcohol alcohol);
}
