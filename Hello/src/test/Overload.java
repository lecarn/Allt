package test;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Overload {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Första sidan:");
		double first = input.nextDouble();

		System.out.println("Andra sidan:");
		double second = input.nextDouble();
		double three = first + second;
		
		double area = area(first, second);
		double omkrets = area(three);
		DecimalFormat df = new DecimalFormat("#.##");
		input.close();
		
		System.out.println("Omkretsen är: "+(df.format(omkrets))+". Arean är: "+(df.format(area)));

	}
	
	public static double area(double num1, double num2) {
		double num3 = num1 * num2;
		return num3;
	}
	
	public static double area(double num1) {
		double num2 = num1 * 2;
		return num2;

	}
}
