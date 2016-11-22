package games.snakeandladder;

public class Snake {

	private Node headPosition;
	
	private Node tailPosition;

	public Snake(Node headPosition, Node tailPosition) {
		super();
		this.headPosition = headPosition;
		this.tailPosition = tailPosition;
	}

	public Node getHeadPosition() {
		return headPosition;
	}

	public void setHeadPosition(Node headPosition) {
		this.headPosition = headPosition;
	}

	public Node getTailPosition() {
		return tailPosition;
	}

	public void setTailPosition(Node tailPosition) {
		this.tailPosition = tailPosition;
	}
}
