package test;

import java.util.Random;
import java.util.Scanner;

public class HelloWorld2 {

	public static void main(String[] args) {
		Random rand = new Random();
		int random = rand.nextInt(5);
		//Tar fram random siffra till ver random
		int guess = 0;
		int u_number = 101;



		do 

			if (u_number == random) {
				System.out.println("Bra jobbat!");
				System.exit(1);
				System.out.println("Rätt nummer var "+random+".");
			}
			else if (guess == 3) {
				System.out.println("Rätt nummer var "+random+".");
				System.out.println("Du är dum!");
				System.out.println("BooooooooooooooooooooooooooooooooooM!");
				System.exit(1);;
			}
			else {
				Scanner input = new Scanner(System.in);
				System.out.println("Gissa nummer");
				u_number = input.nextInt();
				guess = guess+1;
			}while (guess <4);
		
	}

}
