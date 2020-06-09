package com.company;



import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);


        Works uselessWorks = new Works();
        int currentId = 0;
        //Reading the XML and adding to array.
        ArrayList<Account> accList = new ArrayList<>();

        accList = (ArrayList<Account>) XmlEncoder.read();

        //Makes person put in ID to get the correct account.
        try {
            System.out.println(uselessWorks.getTime() + "\nEnter your ID: ");
            currentId = input.nextInt();
            //If letter were put you go into debugger
        } catch (java.util.InputMismatchException e) {
            Works works = new Works(0 ,accList);
            works.debugger();

        } catch (Exception e) {
            System.out.println("You failed something very bad");
            System.exit(0);
        }
        for (int i = 0; i < accList.size(); i++) {
            if (currentId == accList.get(i).getId()) {
                System.out.println("Success");
                Works works = new Works(i, accList);
                works.startBankomat();
            }

        }
        System.out.println("Account doesn't exist.");
        System.out.println("Do you want to create an new account? Y/N");
        String answer = input.next();


        //if you wanna create new account
        if (answer.equalsIgnoreCase("y")) {
            try {

                System.out.println("Whats your name?");
                String name = input.next();

                accList.add(new Account(currentId, name, 0, uselessWorks.getTime()));


            } catch (Exception e) {
                System.out.println("Fail");
            }
            for (int i = 0; i < accList.size(); i++) {
                if (currentId == accList.get(i).getId()) {
                    System.out.println("Success");
                    Works works = new Works(i, accList);
                    works.startBankomat();
                }

            }

        }
        System.out.println("Good bye");
    }
}
