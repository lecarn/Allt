package Prov;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// Startar scanner och lägger till se variablar som används under hela tiden
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

			// tar de tal user skrev in och kör metod count
			answer = count(num1, num2);
			System.out.println("Svaret är: " + answer);

			// kollar om du vill fortsätta
			System.out.println("Vill du fortsätta? Y/N");
			choice = input.next();

			// Kollar om du vill behålla tidigare tal.
			while (choice.equalsIgnoreCase("Y")) {
				saveAnswer = answer;
				System.out.println("Vill spara ditt senaste resultat? Y/N");
				choice = input.next();

				// Om user vill spara tidigare resultat så visar den de sparade resultaten
				// och user väljer var de ska sparas
				if (choice.equalsIgnoreCase("Y")) {
					System.out.println("Dina tidigare sparade tal är(0 betyder ej sparat tal)" + "\nTal 1: " + saved[1]
							+ "\nTal 2: " + saved[2] + "\nTal 3: " + saved[3]
							+ "\nVart vill du spara ditt tal 1,2 eller 3?");
					int i = input.nextInt();
					saved[i] = saveAnswer;
					safe = true;
					System.out.println(saved[i]);
				}
				// om user inte vill spara tidigare tal men forsätta med nya
				else {
					saveAnswer = 0;
					safe = false;
					System.out.println("Skriv in dina 2 tal(endast siffror)");
					num1 = input.nextDouble();
					num2 = input.nextDouble();
					System.out.println("Tal 1 = " + num1 + "\n" + "Tal 2 = " + num2);
					answer = count(num1, num2);
				}
				// om user har sparade nummer så efterfrågas om de vill användas.
				if (safe = true) {
					System.out.println("Vill du använda ett av dina sparade tal? Y/N(R rensar tidigare sparade tal)");
					choice = input.next();

					if (choice.equalsIgnoreCase("y")) {
						System.out.println("Vilket av dina tidigare tal vill du använda?" + "\nTal 1: " + saved[1]
								+ "\nTal 2: " + saved[2] + "\nTal 3: " + saved[3]);
						int j = input.nextInt();
						num1 = saved[j];
						System.out.println("Du har valt att använda ditt sparade nummer: " + num1 + "\n"
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
				System.out.println("Svaret är: " + answer);
				System.out.println("Vill du köra igen? Y/N");
				choice = input.next();
			}
			// Ger text att de avslutas och avslutar programmet.
			if (choice.equalsIgnoreCase("n")) {
				System.out.println("Avslutar programmet.");
				System.exit(0);
			}
			System.out.println("Svaret är: " + answer);
			System.out.println("Vill du köra igen? Y/N(");
			choice = input.next();
		}
		// fångar alla exceptions i ett
		catch (Exception e) {
			System.out.println("Nånting gick lite fel här(förmodligen SBS)");

		}
	}// main

	// låter user göra ett val om hur talen ska hanteras och sparas/return answer(om
	// annat än 1-4 välj så skickar den felmeddelande)
	public static double count(double num1, double num2) {
		System.out.println("Gör ett val: 1 för Plus(+), 2 för minus(-), 3 för gånger(*), 4 för delat(/)");
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
			System.out.println("Nånting snett(förmodligen SBS");

		}
		return answer;
	}// count

	// metod för plus
	public static double plus(double num1, double num2) {
		double answer = num1 + num2;
		return answer;
	}

	// metod för minus
	public static double sub(double num1, double num2) {
		double answer = num1 - num2;
		return answer;
	}

	// metod för gånger
	public static double mult(double num1, double num2) {
		double answer = num1 * num2;
		return answer;
	}

	// metod för delat
	public static double div(double num1, double num2) {
		double answer = num1 / num2;
		return answer;
	}

}// class
