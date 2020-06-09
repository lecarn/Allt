package DTO;

public class Person {
    private String name;
    private int age;
    private int rating;

    Person(String name, int age, int rating){this.name = name; this.age = age; this.rating = rating;}

    public void print(){
        System.out.println("Name: "+ name+"\n Age: "+age+"\n Rating: "+rating);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
}
