package test;

import java.util.Scanner;

public class HelloWorld {


	public static void main(String[] args) {


		Scanner input = new Scanner(System.in);
		System.out.println("Hur m�nga t�nder �r borstade?");
		int number_of_teeth = input.nextInt();
		teeth(number_of_teeth);
		
		System.out.print("Klar, g�r nu ren tandborsten");

	}
	public static void teeth(int number_of_teeth) {
		if (number_of_teeth >=32) {
			System.out.println("T�nder redan borstade");
		}else{
			while (number_of_teeth<=31) {
				System.out.println("Borstar en tand");
				number_of_teeth = number_of_teeth+1;
				System.out.println("T�nder borstade "+number_of_teeth);
			}	
		} 
		
	}
}
