package Composite;

import java.util.ArrayList;
import java.util.List;

public class ManagingDirector implements Person{
    String name;
    int age;
    List<Person> underlings = new ArrayList<>();

    public ManagingDirector(String name, int age){ this.name = name; this.age = age;}

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int getAge() {
        return age;
    }
    public void addUnderling(Person b){
        underlings.add(b);
    }
    public void removeUnderling(Person b){
        underlings.remove(b);
    }
    public void print(){
        Print.printInfo(this);
        System.out.println("His/her underlings are: ");
        Print.printUnderlings(this.underlings);
    }
}
