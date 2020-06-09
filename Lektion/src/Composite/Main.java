package Composite;

public class Main {

    public static void main(String[] args){
        Employee eOne = new Employee("Elisabeth Fritzl", 35);
        Employee eTwo = new Employee("Yo mama", 52);
        Boss bOne = new Boss("Fru Fritzl", 55);
        ManagingDirector mdOne = new ManagingDirector("Josef Fritzl", 65);

        mdOne.addUnderling(eOne);
        eOne.addBoss(mdOne);
        bOne.addUnderling(eTwo);
        eTwo.addBoss(bOne);
        bOne.addBoss(mdOne);
        mdOne.addUnderling(bOne);

        mdOne.print();
    }
}
