package snakeandladder;

import java.util.Random;

public class Board {
	int size;
	Cell[][] boardGrid;
	
	public Board(int size) {
		initializeBoard(size);
	}

	private void initializeBoard(int size) {
		this.size=size;
		boardGrid=new Cell[size][size];
		
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				int pos=i*size+j;
				boardGrid[i][j]=new Cell(pos, null);
			}
		}
		
		addLadders();
		
		addSnakes();
	}
	
	private void addLadders() {
		int ladderCount=0;
		Random random=new Random();
		while(ladderCount<5) {
			int startPoint=random.nextInt(size*size)+1;
			int endPoint=startPoint+random.nextInt(size*size-startPoint);
			
			Jump jump=new Jump(startPoint, endPoint);
			int posX=startPoint/size;
			int posY=startPoint%size;
			boardGrid[posX][posY].setJump(jump);
			ladderCount++;
		}
	}
	
	private void addSnakes() {
		int snakeCount=0;
		Random random=new Random();
		while(snakeCount<5) {
			int startPoint=random.nextInt(size*size);
			int endPoint=random.nextInt(startPoint-1);
			
			Jump jump=new Jump(startPoint, endPoint);
			int posX=startPoint/size;
			int posY=startPoint%size;
			boardGrid[posX][posY].setJump(jump);
			snakeCount++;
			
		}
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Cell[][] getBoardGrid() {
		return boardGrid;
	}

	public void setBoardGrid(Cell[][] boardGrid) {
		this.boardGrid = boardGrid;
	}

	public int nextPosition(int currPosition, int diceOutcome) {
		int newPos=currPosition+diceOutcome;
		if(newPos>=size*size) {
			return newPos;
		}
		
		int posX=newPos/size;
		int posY=newPos%size;
		
		if(boardGrid[posX][posY].getJump()==null) {
			return newPos;
		}
		
		int nextPosition=boardGrid[posX][posY].getJump().getEndPoint();
		
		if(nextPosition<newPos) {
			System.out.println("Allas, you have been bitten by snake");
			return nextPosition;
		}
		
		System.out.println("Hooray, you have climbed up the ladder");
		return nextPosition;
		
	}

	public boolean isBoardCrossed(int nextPosition) {
		return nextPosition>=size*size;
	}
	
	
}
