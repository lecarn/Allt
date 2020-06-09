package openlogfile;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int test;
        Scanner scn = new Scanner(System.in);
        System.out.println("How many times?");
        int times = scn.nextInt();

        for (int i= 0; i < times; i++){
            test = OpenLogFile.getInstance().getTimes();
        }



    }
}

