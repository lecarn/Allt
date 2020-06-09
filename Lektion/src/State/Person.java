package State;

import java.util.ArrayList;
import java.util.List;

public class Person {
    String name;
    int salary;
    Boolean boss = false;
    List<Person> slaves = new ArrayList<>();

    public Person(String name, int salary){this.name = name; this.salary = salary;}

    public void print(){
        System.out.println("\nMitt namn är: "+ name +"\n Jag tjänar: "+salary);
        if (boss){
            System.out.println("Mina anställda är: ");
            for(Person p : slaves) {
                System.out.println(p.getName());
                System.out.println("Han har i lön: "+p.getSalary());
            }
        }
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getSalary() { return salary; }
    public void setSalary(int salary) { this.salary = salary; }
    public Boolean getBoss() { return boss; }
    public void setBoss(Boolean boss) { this.boss = boss; }
    public List<Person> getSlaves() { return slaves; }
    public void setSlaves(List<Person> slaves) { this.slaves = slaves; }
    public void buySlave(Person p){ slaves.add(p);}
    public void killSlave(Person p){ slaves.remove(p);
        System.out.println(p.getName()+" has been killed!");}



}
