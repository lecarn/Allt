package com.com;

import java.sql.SQLException;
import java.util.Scanner;

public class Chooser {
    Scanner scn = new Scanner(System.in);
    int choice;
    MongoDB mongoDB = new MongoDB();

    Chooser(){}

    public void Choose() throws SQLException {
        System.out.println("-----------------------------");
        System.out.println("Gör ett val");
        System.out.println("1, För att skapa person");
        System.out.println("2, För att leta person");
        System.out.println("3, För att uppdatera person");
        System.out.println("4, För att exit");
        System.out.println("-----------------------------");
        if (!scn.hasNextInt()) {
            System.out.println("Use numbers dummy");
        }
        choice = scn.nextInt();

        switch(choice){
            case 1:
                mongoDB.create();
                Choose();
            case 2:
                mongoDB.show();
                Choose();
            case 3:
                mongoDB.edit();
                Choose();
            case 4:
                break;
            default:
                System.out.println("Nått snett");
                break;
        }
    }
}
