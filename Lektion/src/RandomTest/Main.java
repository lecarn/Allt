package RandomTest;

public class Main {

    public static void main(String[]args){
        Object ob1 = new Object(6);
        Object ob2 = ob1;

        System.out.println(ob1.getTal());
        System.out.println(ob2.getTal());
        ob1.setTal(15);
        System.out.println(ob1.getTal());
        System.out.println(ob2.getTal());
    }
}
