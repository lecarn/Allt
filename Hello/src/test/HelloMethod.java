package test;

import java.util.Scanner;

public class HelloMethod {

	public static void main(String[] args) {

		int value1 = input();
		int value2 = input();

		int valuetwo = bigger(value1, value2);
		System.out.println("De st�rre numret var: "+valuetwo);	
	}
	public static int input() {
		Scanner input = new Scanner(System.in);
		System.out.println("Ett nummer?");
		int value = input.nextInt();

		return value;


	}
	public static int bigger(int num1, int num2) {
		int sum;
		if (num1 > num2)
			sum = num1;
		else
			sum = num2;

		return sum;
	}

}