package Command;

import java.util.Scanner;

public class Main {

    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);
        System.out.println("Give string");
        String a = scn.nextLine();
        VowelsToUpperCaseCommand v = new VowelsToUpperCaseCommand();
        ConsonantsToUpperCaseCommand c = new ConsonantsToUpperCaseCommand();
        WhitespaceRemovalCommand w = new WhitespaceRemovalCommand();
        VowelsToWhilespaceCommand vw = new VowelsToWhilespaceCommand();
        System.out.println(a);
        v.execute(a);
        c.execute(a);
        w.execute(a);
        vw.execute(a);

    }
}
