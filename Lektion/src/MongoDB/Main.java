package MongoDB;

public class Main {
    public static void main(String[]args){

        Store store = new Store("hejsan", 15.2);

        System.out.println(store);


    }


}

class Store {

    String name;
    double price;

    public Store(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String toString(){
        return "This store sells " + name + "at the price of " + price;
    }

}
