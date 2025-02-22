package tictactoe;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Game {
	private Board board;
	Deque<Player> playersQueue;

	public Game() {
		initializeGame();
	}

	private void initializeGame() {

		this.board = new Board(3);
		playersQueue = new ArrayDeque<Player>();

		Player player1 = new Player(1, new MarkO());
		Player player2 = new Player(0, new MarkX());

		playersQueue.addLast(player2);
		playersQueue.addLast(player1);

	}

	public void startGame() {
		System.out.println("Welcome to the tic tac toe game");

		Scanner scanner = new Scanner(System.in);

		try {

			while (true) {

				if (!board.isPlayable()) {
					System.out.println("Game Over.");
				}

				Player currPlayer = getNextPlayer();

				System.out.println("Your turn player " + currPlayer.getId());

				playTurnForCurrPlayer(currPlayer, scanner);

				movePlayerToLast(currPlayer);

				board.printBoard();

				if (hasPlayerWon(currPlayer)) {
					System.out.println("Congrats, You have won...");
					break;
				}

				System.out.println();
			}
		} finally {
			scanner.close();
		}
	}

	private void playTurnForCurrPlayer(Player currPlayer, Scanner scanner) {
		while (true) {

			System.out.println("Please enter position");
			int xPos = scanner.nextInt();
			int yPos = scanner.nextInt();

			if (!board.isPositionPlayable(xPos, yPos)) {
				System.out.println("Invalid Position.");
				continue;
			}
			
			board.markPositionForPlayer(xPos, yPos, currPlayer.getAssignedMark());

			return;
		}

	}

	public Player getNextPlayer() {
		Player nextPlayer = playersQueue.removeFirst();
		return nextPlayer;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Deque<Player> getPlayersQueue() {
		return playersQueue;
	}

	public void setPlayersQueue(Deque<Player> playersQueue) {
		this.playersQueue = playersQueue;
	}

	public boolean hasPlayerWon(Player currPlayer) {
		for (int i = 0; i < board.getSize(); i++) {
			if (isColumnMarkedWith(i, currPlayer.getAssignedMark())) {
				return true;
			}
		}
		for (int i = 0; i < board.getSize(); i++) {
			if (isRowMarkedWith(i, currPlayer.getAssignedMark())) {
				return true;
			}
		}

		if (isLeftToRightDiagonalMarkedWith(currPlayer.getAssignedMark())) {
			return true;
		}

		if (isRightToLeftDiagonalMarkedWith(currPlayer.getAssignedMark())) {
			return true;
		}

		return false;

	}

	private boolean isColumnMarkedWith(int col, Mark mark) {
		for (int i = 0; i < board.getSize(); i++) {
			if (board.getBoardGrid()[i][col] == null || board.getBoardGrid()[i][col] != mark) {
				return false;
			}
		}

		return true;
	}

	private boolean isRowMarkedWith(int row, Mark mark) {
		for (int i = 0; i < board.getSize(); i++) {
			if (board.getBoardGrid()[row][i] == null || board.getBoardGrid()[row][i] != mark) {
				return false;
			}
		}

		return true;
	}

	private boolean isLeftToRightDiagonalMarkedWith(Mark mark) {
		for (int i = 0; i < board.getSize(); i++) {
			if (board.getBoardGrid()[i][i] == null || board.getBoardGrid()[i][i] != mark) {
				return false;
			}
		}
		return true;
	}

	private boolean isRightToLeftDiagonalMarkedWith(Mark mark) {
		for (int i = 0; i < board.getSize(); i++) {
			if (board.getBoardGrid()[i][board.getSize() - i - 1] == null
					|| board.getBoardGrid()[i][board.getSize() - i - 1] != mark) {
				return false;
			}
		}
		return true;
	}

	public void movePlayerToLast(Player currPlayer) {
		playersQueue.addLast(currPlayer);

	}

}
