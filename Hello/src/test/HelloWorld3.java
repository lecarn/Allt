package test;

import java.util.Scanner;

public class HelloWorld3 {

	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		System.out.println("Minutes ?");
		double minutes = input.nextDouble();
		//Save user input
		double hours = minutes / 60;
		double days = hours / 24;
		double year = days / 365;
		
		System.out.print("That is: "+year+" years");
	}

}
