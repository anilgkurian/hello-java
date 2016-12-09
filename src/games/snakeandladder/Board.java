package games.snakeandladder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * Represents the complete SnL board which has a list of nodes (1-100), snakes,
 * ladders & coins (for players)
 *
 * @author Anil Kurian
 *
 */
public class Board {

	private final List<Node> nodes = new ArrayList<Node>();

	private final List<AddOn> snakes = new ArrayList<AddOn>();

	private final List<AddOn> ladders = new ArrayList<AddOn>();

	private final List<Coin> coins = new ArrayList<Coin>();

	// a snake's head or tail or top or bottom of a ladder is in this node
	// used to avoid having same node as snake's head and ladder
	private final Set<Integer> nodeOfInterest = new HashSet<Integer>();

	public Board() {
		for (int i = 1; i <= 100; i++) {
			final Node n = new Node(i);
			nodes.add(n);
		}
	}

	public Board addPlayer(final String name) {
		coins.add(new Coin(nodes.get(0), name));
		return this;
	}

	public List<Coin> getCoins() {
		return coins;
	}

	public Board addSnake(final int head, final int tail) {
		if ((tail >= head) || !nodeOfInterest.add(head) || !nodeOfInterest.add(tail)) {
			Game.err("Snake ignored " + head + "," + tail);
			return this;
		}
		snakes.add(new AddOn(nodes.get(head), nodes.get(tail)));
		return this;
	}

	public Board addLadder(final int head, final int tail) {
		if ((tail >= head) || !nodeOfInterest.add(head) || !nodeOfInterest.add(tail)) {
			Game.err("Ladder ignored " + head + "," + tail);
			return this;
		}
		ladders.add(new AddOn(nodes.get(head), nodes.get(tail)));
		return this;
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public List<AddOn> getSnakes() {
		return snakes;
	}

	public List<AddOn> getLadders() {
		return ladders;
	}
}
