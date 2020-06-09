package State;

public class Main {

    public static void main(String[] args){
        Person boss = new Person("Mr. Boss", 15000);
        boss.print();
        boss.setBoss(true);
        Person slave = new Person("Mr. slave", -500);
        boss.buySlave(slave);
        Person slave2 = new Person("Slave No-name", -3);
        boss.buySlave(slave2);
        boss.print();
        boss.killSlave(slave);
        boss.print();

    }
}
