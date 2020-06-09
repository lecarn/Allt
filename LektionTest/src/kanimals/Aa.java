package kanimals;

public class Aa implements animal {

	int age;
	
	Aa(){}
	@Override
	public String whatDoesTheAnimalDoes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String whatDoesTheAnimalSay() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub

	}

	
//	public void setAge(int age) {
//		this.age = age;
//
//	}
	@Override
	public void setAge(double age) {
		this.age = (int) age;
	}
	public int getAge() {
		return age;
	}

}
