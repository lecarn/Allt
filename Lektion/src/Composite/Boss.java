package Composite;

import java.util.ArrayList;
import java.util.List;

public class Boss implements Person {
    String name;
    int age;
    List<Person> underlings = new ArrayList<>();
    Person boss;

    public Boss(String name, int age){ this.name = name; this.age = age; }

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
    public void addUnderling(Person e){
        underlings.add(e);
    }
    public void removeUnderlign(Person e){
        underlings.remove(e);
    }
    public void listUnderlings(){
        for(Person e: underlings){
            System.out.print(e.getName());
            System.out.println(e.getAge());
        }
    }
    public void addBoss(Person md){
        boss = md;
    }
    public Person getBoss(){
        return boss;
    }

    public void print(){

        Print.printInfo(this);
        System.out.println("His/her boss is: "+ boss);
        Print.printUnderlings(this.underlings);
    }

}
