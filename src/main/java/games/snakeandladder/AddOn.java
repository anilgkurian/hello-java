package games.snakeandladder;

/**
 * Represents a Snake or a Ladder which has a head and tail position.
 *
 * @author Anil Kurian
 *
 */
// TODO: a better name
public class AddOn {

	private Node headPosition;

	private Node tailPosition;

	public AddOn(final Node headPosition, final Node tailPosition) {
		this.headPosition = headPosition;
		this.tailPosition = tailPosition;
	}

	public Node getHeadPosition() {
		return headPosition;
	}

	public void setHeadPosition(final Node headPosition) {
		this.headPosition = headPosition;
	}

	public Node getTailPosition() {
		return tailPosition;
	}

	public void setTailPosition(final Node tailPosition) {
		this.tailPosition = tailPosition;
	}
}
