package snakeandladder;

public class Player {
	int id;
	String name;
	int position;

	public Player(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.position = 1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

}
