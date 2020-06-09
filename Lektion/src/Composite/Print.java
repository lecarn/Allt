package Composite;

import java.util.List;

public class Print {

    public static void printInfo(Person p) {
        System.out.println("The name is: " + p.getName());
        System.out.println("The age are: " + p.getAge());

    }
    public static void printUnderlings(List<Person> p){
        for(Person e: p){
            System.out.print(e.getName());
            System.out.println(e.getAge());
        }
    }
}
