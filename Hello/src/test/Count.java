package test;

import java.util.Random;
import java.util.Scanner;

public class Count {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// Tar emot endast 2 siffrigt nummer
		System.out.println("Skriv ett tal med 2 siffror mellan 01-99.");
		while(!input.hasNextInt()) {
			input.nextLine();
			System.out.println("Skriv ett tal med 2 siffror mellan 01-99.");
		}
		
		String number = input.nextLine();
		while (number.length() !=2) {
			System.out.println("Skriv ett tal med 2 siffror mellan 01-99.");
			number = input.nextLine();
		}
		//tar fram random nummer
		Random random = new Random();
		int rNum = random.nextInt(98) +1;
		String rString = Integer.toString(rNum);
		
		
		//om siffra 1-9 printa 0 innan
		if (rString.length() != 2) {
			rString = "0"+rString;
		}
		System.out.println("Lotto numret �r:"+rString);
		//Kollar om du vann
		if(rString.equals(number)) {
			System.out.println("Du vann 10 000kr!!!");
		}
		else if (number.charAt(0)== rString.charAt(1) && number.charAt(1) == rString.charAt(0))
			System.out.println("Du vann 5 000kr!");
		else if(number.charAt(0) == rString.charAt(0) && number.charAt(1) != rString.charAt(1) || number.charAt(1) == rString.charAt(1) && number.charAt(0) != rString.charAt(0))
			System.out.println("Du vann 1 000kr!!!");
		else
			System.out.println("Du f�rlorade!");
		
		//System.out.println(number+"<--ditt  random -->"+rString);




	}//main
}//class