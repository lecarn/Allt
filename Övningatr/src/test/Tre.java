package test;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Tre {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in); //starta scanner input
		
		System.out.println("Hur m�nga liter vatten ska kokas?");
		while(!input.hasNextDouble()) {
			input.next();
			System.out.println("Ange endast hur m�nga liter i siffror");
		}
		double litre = input.nextDouble();
		// antal liter anges(while f�r att se till att endast siffror kommer in)

		System.out.println("Vad var start tempraturen ?");
		while(!input.hasNextDouble()) {
			input.next();
			System.out.println("Ange endast hur varmt de var i siffror");
		}
		double start = input.nextDouble();
		//tar emot start temp

		System.out.println("Vad var slut tempraturen ?");
		while(!input.hasNextDouble()) {
			input.next();
			System.out.println("Ange endast hur varmt de var i siffror");
		}
		double end = input.nextDouble();
		//tar emot slut temp
		
		double energy = counting(litre, start, end); //Skickar input till counting.
		DecimalFormat df = new DecimalFormat("#.##"); //visar double i 2 decimaler.
		System.out.println("Det anv�ndes "+(df.format(energy))+" joules");// ger svar.


	}//main

	public static double counting(double num1, double num2, double num3) {
		double answer = num1 * (num3-num2) * 4184;
		return answer;
	}//counting

}//class


