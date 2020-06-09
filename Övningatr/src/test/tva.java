package test;

import java.util.Scanner;

public class tva {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("How far did you run in km?");
		double length = input.nextDouble();
		
		System.out.println("How long did it take you in minutes?");
		double time = input.nextDouble();
		
		double kmh = (length / time) * 60;
		
		double runnerD = 24 * 1.6;
		double runnerA = (runnerD / 100.35) * 60;
		System.out.println(Math.round(runnerA)+"km/h Springer en bra löpare, du sprang:"+ Math.round(kmh)+"km/h");

	}

}
