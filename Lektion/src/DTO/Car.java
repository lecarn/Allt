package DTO;

public class Car {

    String name;
    String model;
    String color;

    Car(String name, String model, String color){this.name= name; this.model= model; this.color= color;}

    public void print(){
        System.out.println("Name: "+ name+"\n Model: "+model+"\n Color: "+color);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
}
