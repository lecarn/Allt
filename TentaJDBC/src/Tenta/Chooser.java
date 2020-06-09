package Tenta;

import java.sql.SQLException;
import java.util.Scanner;

public class Chooser {

    Scanner scn = new Scanner(System.in);
    DBShit dbShit = new DBShit();
    int choice;
    String user;
    String password;

    Chooser() throws SQLException {}

    public void choose() throws SQLException {

        System.out.println("-----------------------------");
        System.out.println("Make your choice");
        System.out.println("1, to show users");
        System.out.println("2, to create new");
        System.out.println("Anything except above, to exit");
        System.out.println("-----------------------------");
        choice = scn.nextInt();

        switch(choice){
            case 1:
                dbShit.getAll();
                choose();
            case 2:
                System.out.println("What username?");
                user = scn.next();
                System.out.println("What password?");
                password = scn.next();
                dbShit.createUser(user, password);
                choose();
            default:
                System.exit(0);
        }


    }
}
