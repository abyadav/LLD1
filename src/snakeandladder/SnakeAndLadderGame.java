package snakeandladder;

import java.util.ArrayDeque;
import java.util.Deque;

public class SnakeAndLadderGame {
	
	Deque<Player> playersQueue;
	Dice dice;
	Board board;
	
	public SnakeAndLadderGame() {
		initializeGame();
	}
	
	private void initializeGame() {
		playersQueue=new ArrayDeque<Player>();
		dice=new Dice(1);
		board=new Board(10);
		
		Player player1=new Player(1, "Abhishek");
		playersQueue.addLast(player1);
		
		Player player2=new Player(2, "Ajay");
		playersQueue.addLast(player2);
		
	}
	
	public void playGame() {
		System.out.println("Starting the game");
		
		while(playersQueue.size()>1) {
			Player currPlayer=playersQueue.removeFirst();
			System.out.println("Rolling dice now for:- "+ currPlayer.getName());
			
			int diceOutcome=dice.roll();
			System.out.println("Received dice outcome:- "+diceOutcome);
			
			int nextPosition = board.nextPosition(currPlayer.getPosition(), diceOutcome);
			
			System.out.println("Next Position is: "+nextPosition);
			
			currPlayer.setPosition(nextPosition);
			
			if(board.isBoardCrossed(nextPosition)) {
				System.out.println("Congrats"+" "+currPlayer.getName()+" You have won.");
			} else {
				playersQueue.addLast(currPlayer);
			}
			System.out.println();
			
		}
	}
}
