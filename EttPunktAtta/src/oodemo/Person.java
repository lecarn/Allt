package oodemo;

public class Person {
	Company company;
	String name;
	Company myEmpolyers;
	boolean isMarried = false;
	int id = 0;
	
	public Person(String name, int id){
		myEmpolyers = null;
		name = name;
		this.id = id;
	}
	
	public void isNowMarried() {
		isMarried = true;
	}
	
	public void isNowDivorced() {
		isMarried = false;
	}
	
	public String getName() {
		return name;
	}
	
}
