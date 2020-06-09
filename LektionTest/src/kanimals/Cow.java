package kanimals;


public class Cow implements Kanimals {
	//Klassvariabler
	String name;
	int age;
	//Definierar konstruktorn
	Cow(String name, int age){
	this.name = name;
	this.age = age;
	}
	@Override
	public String whatDoesTheAnimalDoes() {
	return null;
	}
	@Override
	public String whatDoesTheAnimalSay() {
	return "hejhopp";
	}
	@Override
	public void setName(String name) {
	}
	@Override
	public void setAge(int age) {
	}
	
	public void setAge(double age) {
		
	}
}