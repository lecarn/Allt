package oodemo;

public class Main {

	public static void main(String[] args) {
		
		Person jonathanHarr = new Person(id: 1, name: "Jonathan Harr");
		
		jonathanHarr.isNowMarried();
		
		System.out.println("Is Jonathan Married " + jonathanHarr.isMarried());

	}
}