package test;

import java.text.DecimalFormat;
import java.util.Scanner;

public class HelloKMmiles {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("How many kilo?");
		double kilo = input.nextDouble();
		double pounds = pound(kilo);
		DecimalFormat df = new DecimalFormat("#.##");
		

		input.close();
				System.out.print(kilo+" kilo are "+(df.format(pounds))+" pounds.");


	}
	public static double pound(double kilo) {
	double pounds2;
	pounds2 = kilo * 2.204;
	return pounds2;
	}
}
