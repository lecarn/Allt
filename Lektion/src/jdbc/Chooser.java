package jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class Chooser {
    Scanner scn = new Scanner(System.in);
    int choice;
    DbShit db = new DbShit();
    Chooser() throws SQLException {}

    public void Choose() throws SQLException {
        System.out.println("-----------------------------");
        System.out.println("Make your choice");
        System.out.println("1, to show first 10");
        System.out.println("2, to show next 10");
        System.out.println("3, to show last 10");
        System.out.println("4, to select row and update");
        System.out.println("-----------------------------");
        if(!scn.hasNextInt()){
            System.out.println("Use numbers dummy");
        }
        choice = scn.nextInt();

        switch(choice){
            case 1:
                db.getFirstTen();
        }
    }
}
