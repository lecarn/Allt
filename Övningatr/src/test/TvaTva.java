package test;

import java.util.Random;
import java.util.Scanner;

public class TvaTva {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Skriv ett tal med 2 siffror mellan 01-99.");

		// Stoppar om de inte �r int
		while (!input.hasNextInt()) {
			System.out.println("Skriv ett tal med 2 siffror mellan 01-99 och inga bokst�ver/tecken");
			String number = input.nextLine();

		}

		String number = input.nextLine();

		// Tar emot endast 2 siffrigt nummer
		while (number.length() != 2) {
			System.out.println(
					"Skriv ett tal med 2 siffror mellan 01-99. Kom ih�g 0:an om du vill v�lja ett en siffrigt nummer.");
			number = input.nextLine();
		}

		// tar fram random nummer
		Random random = new Random();
		int rNum = random.nextInt(98) + 1;
		String rString = Integer.toString(rNum);

		// om siffra 1-9 printa 0 innan
		if (rString.length() != 2) {
			rString = "0" + rString;
		}
		System.out.println("Lotto numret �r:" + rString);
		// Kollar om du vann
		if (rString.equals(number)) {
			System.out.println("Du vann 10 000kr!!!");
		} else if (number.charAt(0) == rString.charAt(1) && number.charAt(1) == rString.charAt(0))
			System.out.println("Du vann 5 000kr!");
		else if (number.charAt(0) == rString.charAt(0) && number.charAt(1) != rString.charAt(1)
				|| number.charAt(1) == rString.charAt(1) && number.charAt(0) != rString.charAt(0))
			System.out.println("Du vann 1 000kr!!!");
		else
			System.out.println("Du f�rlorade!");

		input.close();

		// Medveten att om du f�rst skriver en siffra sedan 2 bokst�ver s� lyckas du ta
		// dig igenom while satserna som ska f�nga de felen. Men de l�sningar jag
		// hittade var lite �ver min kunskap f�r tillv�llet och gav mer att l�ra mig annat
		// just nu.
	}// main
}// class