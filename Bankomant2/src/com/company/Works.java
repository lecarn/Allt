package com.company;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


class Works {

    private int id;
    private ArrayList<Account> accList = new ArrayList<>();
    private int withdraw;
    private int deposit;
    private int balance;
    private Scanner input = new Scanner(System.in);

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private LocalDateTime now = LocalDateTime.now();
    private String time = dtf.format(now);

    Works(){}
    Works(int id, ArrayList<Account> accList){
        this.id = id;
        this.accList = accList;
    }

    //Method to start the banking7
    void startBankomat() {
        try {


            System.out.println("-----------------------");
            System.out.println("Welcome " + accList.get(id).getName());
            System.out.println("Press 1 for balance \n" + "Press 2 for withdraw \n" + "Press 3 for deposit\n" + "Press 4 information about account\n"
                    + "Press 5 to exit\n");
            int choose = input.nextInt();

            switch (choose) {
                case 1:
                    System.out.println("Your balance are: " + accList.get(id).getBalance());
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                deposit();
                break;
                case 4:
                    accList.get(id).show();
                    break;
                case 5:
                    System.out.println("Thank you for using Hellbank bankomat, have a nice day " + accList.get(id).getName());
                    XmlEncoder.write(accList);
                    System.exit(0);
                default:
                    System.out.println("Nånting snett(förmodligen SBS)");


            }
            startBankomat();

        } catch(Exception e) {
            System.out.println("Something wrong, try again and dont fuck up this time.");

        }
    }

    //Method for withdrawing money
    private void withdraw() {
        try {
            System.out.println("Your current balance are: " + accList.get(id).getBalance() + "\nHow much do you wanna withdraw?");
            balance = accList.get(id).getBalance();
            withdraw = input.nextInt();
            if (balance > withdraw) {
                balance = balance - withdraw;
                accList.get(id).setBalance(balance);
                accList.get(id).setChanges(0-withdraw);
                accList.get(id).change();
            } else {
                System.out.println("Cannot overdraw your account");
                startBankomat();
            }
            System.out.println(withdraw+"Has been withdrawn. \nYour current balance are: " + accList.get(id).getBalance());

        } catch(java.util.InputMismatchException e){
            System.out.println("Failed the simple task to enter numbers...... good luck with the rest of life");
        } catch(Exception e) {
            System.out.println("Something went horribly wrong and this bankomat will now explode");
        }
    }
    //Method for depositing money
    private void deposit() {
        try {
            System.out.println("Your current balance are: " + accList.get(id).getBalance() + "\nHow much do you wanna deposit?");
            balance = accList.get(id).getBalance();
            deposit = input.nextInt();
            accList.get(id).setBalance(balance + deposit);
            accList.get(id).setChangeDate(getTime());
            accList.get(id).setChanges(deposit);
            accList.get(id).change();
            System.out.println(deposit+"Has been deposited. \nYour current balance are: " + accList.get(id).getBalance());

        } catch (java.util.InputMismatchException e) {
            System.out.println("Failed the simple task to enter numbers...... goood luck with the rest of life");
        } catch (Exception e) {
            System.out.println("Something went horribly wrong and this bankomat will now explode");
        }
    }
    //Debugger to show account in program instead of reading XML.
    void debugger() {
        System.out.println("You have entered the admin code. Must be a hacker!");
        for (int i = 0; i < accList.size(); i++) {
            accList.get(i).show();
            System.out.println("---------------------------");
        }
        System.out.println("Would you like to delete any of the account? Y/N");
        String answer = input.next();
        if(answer.equalsIgnoreCase("y")){
            System.out.println("Input id of the account you would like to delete?");
            int del = input.nextInt();

            //kollar igenom accList och tar bort ID som är valt.
            try {
                accList.removeIf(acc -> acc.getId() == del);
                System.out.println("Removing account " + del);
                XmlEncoder.write(accList);
                System.exit(0);
            }catch(Exception e){
                System.out.println("Didn't ");
            }
        }else{
            System.out.println("Good bye");
            System.exit(0);
        }
    }
    String getTime(){
        return time;
    }

}

