package test;

import java.util.Scanner;

public class Ett {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Year ?");

		while(!input.hasNextInt()) { 
			input.next();
			System.out.println("Enter number");  
		}

		int year = input.nextInt();
		input.close();

		if (year % 4 != 0) 
			System.out.println("Not a leap year.");
		else if (year % 4 == 0 && year % 100 == 0 && year % 400 == 0)
			System.out.println("Its a leap year.");
		else if (year % 100 == 0) 
			System.out.println("Not a leap year.");
		else if (year % 400 == 0) 
			System.out.println("Not a leap year.");
		else if (year % 4 == 0) 
			System.out.println("Its a leap year.");
		else 
			System.out.println("Not a leap year.");

	}
}
