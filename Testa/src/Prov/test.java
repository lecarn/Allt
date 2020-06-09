package Prov;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// Startar scanner och l�gger till se variablar som anv�nds under hela tiden
		Scanner input = new Scanner(System.in);
		double num1 = 0;
		double num2 = 0;
		double answer = 0;
		double saveAnswer = 0;
		double[] saved = { 0, 0, 0, 0 };
		boolean safe = false;
		String choice = "n";

		try {
			// be user ge 2 tal
			System.out.println("Skriv in dina 2 tal(endast siffror och ,)");
			num1 = input.nextDouble();
			num2 = input.nextDouble();
			System.out.println("Tal 1 = " + num1 + "\n" + "Tal 2 = " + num2);

			// tar de tal user skrev in och k�r metod count
			answer = count(num1, num2);
			System.out.println("Svaret �r: " + answer);

			// kollar om du vill forts�tta
			System.out.println("Vill du forts�tta? Y/N");
			choice = input.next();

			// Kollar om du vill beh�lla tidigare tal.
			while (choice.equalsIgnoreCase("Y")) {
				saveAnswer = answer;
				System.out.println("Vill spara ditt senaste resultat? Y/N");
				choice = input.next();

				// Om user vill spara tidigare resultat s� visar den de sparade resultaten
				// och user v�ljer var de ska sparas
				if (choice.equalsIgnoreCase("Y")) {
					System.out.println("Dina tidigare sparade tal �r(0 betyder ej sparat tal)" + "\nTal 1: " + saved[1]
							+ "\nTal 2: " + saved[2] + "\nTal 3: " + saved[3]
							+ "\nVart vill du spara ditt tal 1,2 eller 3?");
					int i = input.nextInt();
					saved[i] = saveAnswer;
					safe = true;
					System.out.println(saved[i]);
				}
				// om user inte vill spara tidigare tal men fors�tta med nya
				else {
					saveAnswer = 0;
					safe = false;
					System.out.println("Skriv in dina 2 tal(endast siffror)");
					num1 = input.nextDouble();
					num2 = input.nextDouble();
					System.out.println("Tal 1 = " + num1 + "\n" + "Tal 2 = " + num2);
					answer = count(num1, num2);
				}
				// om user har sparade nummer s� efterfr�gas om de vill anv�ndas.
				if (safe = true) {
					System.out.println("Vill du anv�nda ett av dina sparade tal? Y/N(R rensar tidigare sparade tal)");
					choice = input.next();

					if (choice.equalsIgnoreCase("y")) {
						System.out.println("Vilket av dina tidigare tal vill du anv�nda?" + "\nTal 1: " + saved[1]
								+ "\nTal 2: " + saved[2] + "\nTal 3: " + saved[3]);
						int j = input.nextInt();
						num1 = saved[j];
						System.out.println("Du har valt att anv�nda ditt sparade nummer: " + num1 + "\n"
								+ "Vilket blir ditt andra nummer(skriv med siffor)?");
						num2 = input.nextDouble();
						answer = count(num1, num2);
					}
					if (choice.equalsIgnoreCase("r")) {
						safe = false;
						for (int k = 0; k < 3; k++) {
							saved[k] = 0;
							System.out.println("Sparade tal rensade");
						}
					}

				}
				// ifall
				System.out.println("Svaret �r: " + answer);
				System.out.println("Vill du k�ra igen? Y/N");
				choice = input.next();
			}
			// Ger text att de avslutas och avslutar programmet.
			if (choice.equalsIgnoreCase("n")) {
				System.out.println("Avslutar programmet.");
				System.exit(0);
			}
			System.out.println("Svaret �r: " + answer);
			System.out.println("Vill du k�ra igen? Y/N(");
			choice = input.next();
		}
		// f�ngar alla exceptions i ett
		catch (Exception e) {
			System.out.println("N�nting gick lite fel h�r(f�rmodligen SBS)");

		}
	}// main

	// l�ter user g�ra ett val om hur talen ska hanteras och sparas/return answer(om
	// annat �n 1-4 v�lj s� skickar den felmeddelande)
	public static double count(double num1, double num2) {
		System.out.println("G�r ett val: 1 f�r Plus(+), 2 f�r minus(-), 3 f�r g�nger(*), 4 f�r delat(/)");
		int choose;
		double answer = 0;
		Scanner input = new Scanner(System.in);
		choose = input.nextInt();
		switch (choose) {
		case 1:
			answer = plus(num1, num2);
			break;
		case 2:
			answer = sub(num1, num2);
			break;
		case 3:
			answer = mult(num1, num2);
			break;
		case 4:
			answer = div(num1, num2);
			break;
		default:
			System.out.println("N�nting snett(f�rmodligen SBS");

		}
		return answer;
	}// count

	// metod f�r plus
	public static double plus(double num1, double num2) {
		double answer = num1 + num2;
		return answer;
	}

	// metod f�r minus
	public static double sub(double num1, double num2) {
		double answer = num1 - num2;
		return answer;
	}

	// metod f�r g�nger
	public static double mult(double num1, double num2) {
		double answer = num1 * num2;
		return answer;
	}

	// metod f�r delat
	public static double div(double num1, double num2) {
		double answer = num1 / num2;
		return answer;
	}

}// class
