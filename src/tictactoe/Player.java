package tictactoe;

public class Player {
	private int id;
	private Mark assignedMark;

	public Player(int id, Mark assignedMark) {
		this.id = id;
		this.assignedMark = assignedMark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Mark getAssignedMark() {
		return assignedMark;
	}

	public void setAssignedMark(Mark assignedMark) {
		this.assignedMark = assignedMark;
	}

}
