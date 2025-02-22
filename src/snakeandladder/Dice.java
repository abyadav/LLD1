package snakeandladder;

import java.util.Random;

public class Dice {
	int diceCount;
	int faces;
	
	public Dice(int diceCount) {
		this.diceCount=diceCount;
		faces=6;
	}
	
	public int roll() {
		int rolledCount=0;
		int diceOutcome=0;
		Random random=new Random();
		while(rolledCount<diceCount) {
			diceOutcome=diceOutcome+random.nextInt(faces)+1;
			rolledCount++;
		}
		
		return diceOutcome;
	}
}
