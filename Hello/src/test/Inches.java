package test;

public class Inches {

	public static void main(String[] args) {
		double celsius = 2;
		double 	fahren;
		double celsius2;
		double fahrenTwo = 20;		
		System.out.printf  ("%8s\t%8s\t%s%8s\t%8s","Celsius", "Fahren","|", "Fahren", "Celsius");
		for(int i=2; i<102; i = i+2) {
			fahren = ((9.0/5.0) * celsius + 32.0);
			celsius2 = ((5.0/9.0) * (fahrenTwo - 32.0));
			System.out.printf("%n%8.2f\t%8.2f\t%s%8.2f\t%8.2f",celsius, fahren, "|", fahrenTwo, celsius2);
			celsius = celsius +2;
			fahrenTwo = fahrenTwo +5;

			
		}//for

	}//main
}//class