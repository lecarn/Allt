package kanimals;


public class Main {

	public static void main(String[] args) {
		Cow mu = new Cow("muu", 15);
		Aa aa = new Aa();
		aa.setAge(0,5);
		System.out.println(aa.age);
		aa.setAge(0.5);
		System.out.println(aa.getAge());
		
		System.out.println(mu.whatDoesTheAnimalSay());

	}

}
