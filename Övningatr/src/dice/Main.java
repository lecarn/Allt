package dice;

public class Main {

	public static void main(String[] args) {
		
		
		Dice dice1 = new Dice();
		System.out.println(dice1.rollDice());
		System.out.println(dice1.rollDice());
		System.out.println(dice1.rollDice());
		System.out.println(dice1.rollDice());
		System.out.println(dice1.rollDice());
		System.out.println(dice1.rollDice());
		System.out.println(dice1.rollDice());
		
		for(int i = 0; i < dice1.record.size(); i++) {
			System.out.println("printar resultat: " + dice1.getRecord().get(i));
		}

	}

}
