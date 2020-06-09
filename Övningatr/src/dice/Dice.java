package dice;


import java.util.ArrayList;
import java.util.Random;

public class Dice {

	int sideOfDice = 6;
	ArrayList<Integer> record = new ArrayList<>();
	int i;
	

	Dice() {}

	Dice(int sideOfDice) {
		this.sideOfDice = sideOfDice;
	}
	
	public int rollDice() {
		Random randomGenerator = new Random();
		int anyInt = randomGenerator.nextInt(sideOfDice) +1;
		record.add(anyInt);
		return (anyInt);
	}
	public ArrayList<Integer> getRecord() {
		return record;
	}
	public void setDice(int sideOfDice) {
		this.sideOfDice = sideOfDice;
	}
	public int getDice() {
		return sideOfDice;
	}

}// Dice
