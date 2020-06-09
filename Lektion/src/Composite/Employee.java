package Composite;

public class Employee implements Person {
    String name;
    int age;
    Person boss;

    public Employee(String name, int age){ this.name= name; this.age= age; }
    @Override
    public void setName(String name) {
        this.name= name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setAge(int age) {
        this.age= age;
    }

    @Override
    public int getAge() {
        return age;
    }
    public void addBoss(Person b){
        this.boss= b;
    }
    public void print(){
        Print.printInfo(this);
        System.out.println("His/her boss is: "+ boss);
    }
}
