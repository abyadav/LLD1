package tictactoe;

public class Board {
	private int size;
	private Mark[][] boardGrid;
	private int positionsTaken;

	public Board(int size) {
		this.size = size;
		this.boardGrid = new Mark[size][size];
		this.positionsTaken = 0;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Mark[][] getBoardGrid() {
		return boardGrid;
	}

	public void setBoardGrid(Mark[][] boardGrid) {
		this.boardGrid = boardGrid;
	}

	public int getPositionsTaken() {
		return positionsTaken;
	}

	public void setPositionsTaken(int positionsTaken) {
		this.positionsTaken = positionsTaken;
	}

	public boolean isPositionAlreadyPlayed(int xPos, int yPos) {
		return boardGrid[xPos][yPos] != null;
	}

	public void markPositionForPlayer(int xPos, int yPos, Mark mark) {
		boardGrid[xPos][yPos] = mark;
		positionsTaken++;
	}
	
	public boolean isPlayable() {
		if (positionsTaken == size * size) {
			return false;
		}

		return true;
	}
	
	public void printBoard() {

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (boardGrid[i][j] == null) {
					System.out.print(" ");
				} else {
					System.out.print(boardGrid[i][j].getMark());
				}
				System.out.print(" ");
			}
			System.out.println();
		}

	}
	
	public boolean isPositionPlayable(int xPos, int yPos) {
		if (xPos < 0 || yPos < 0 || xPos >= size || yPos >= size) {
			return false;
		}

		if (isPositionAlreadyPlayed(xPos, yPos)) {
			return false;
		}

		return true;
	}

}
