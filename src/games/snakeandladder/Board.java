package games.snakeandladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

	private static List<Node> nodes = new ArrayList<Node>();

	private static List<AddOn> snakes = new ArrayList<AddOn>();

	private static List<AddOn> ladders = new ArrayList<AddOn>();

	private static List<Coin> coins = new ArrayList<Coin>();

	// a snake's head or tail or top or bottom of a ladder is in this node
	// used to avoid having same node as snake's head and ladder
	private final Set<Integer> nodeOfInterest = new HashSet<Integer>();

	private static List<String> board = new ArrayList<String>();

	public Board() {
		for (int i = 1; i <= 100; i++) {
			final Node n = new Node(i);
			nodes.add(n);
		}
	}

	static {
		for (int i = 1; i <= 100; i++) {
			board.add("" + i);
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
			err("Snake ignored " + head + "," + tail);
			return this;
		}
		snakes.add(new AddOn(nodes.get(head), nodes.get(tail)));
		return this;
	}

	public Board addLadder(final int head, final int tail) {
		if ((tail >= head) || !nodeOfInterest.add(head) || !nodeOfInterest.add(tail)) {
			err("Ladder ignored " + head + "," + tail);
			return this;
		}
		ladders.add(new AddOn(nodes.get(head), nodes.get(tail)));
		return this;
	}

	public boolean move(final Coin coin, final int pos) {
		// printBoard();
		if (coin.getPosition().getNumber() == 100) {
			return true;
		}
		coin.incrementMoves();

		final Node currentNode = coin.getPosition();
		final int newPos = currentNode.getNumber() + pos;
		if (newPos > 100) {
			log("new position is above 100");
			return true;
		}

		log(coin.getPlayer() + " moved by " + pos);
		final Node newNode = nodes.get(newPos - 1);

		for (final AddOn snake : snakes) {
			if (snake.getHeadPosition().equals(newNode)) {
				final Node tailPosition = snake.getTailPosition();
				moveCoin(coin, tailPosition);
				coin.snakeBite();
				log(coin.getPlayer() + " snake bite at " + newNode.getNumber() + ". moved to "
						+ snake.getTailPosition());
				return true;
			}
		}

		for (final AddOn ladder : ladders) {
			if (ladder.getTailPosition().equals(newNode)) {
				final Node headPosition = ladder.getHeadPosition();
				moveCoin(coin, headPosition);
				coin.ladderChance();
				log(coin.getPlayer() + " got ladder at " + newNode.getNumber() + ". moved to "
						+ ladder.getHeadPosition());
				return true;
			}
		}
		moveCoin(coin, newNode);
		log(coin.getPlayer() + " moved by " + pos + " to reach " + newNode.getNumber());

		if (coin.getPosition().getNumber() == 100) {
			for (final Coin othercoin : coins) {
				if (othercoin.getPosition().getNumber() != 100) {
					return true;
				}
			}
			printSummery();
			return false;
		}
		return true;
	}

	private void moveCoin(final Coin coin, final Node tailPosition) {
		final int curBoardPos = coin.getPosition().getNumber() - 1;
		board.set(curBoardPos, coin.getPosition().getNumber() + "");
		coin.setPosition(tailPosition);
		final int newPos = coin.getPosition().getNumber() - 1;
		// Integer.parseInt(board.get(newPos))
		board.set(newPos, coin.getPlayer());
	}

	public void printSummery() {
		print("\n======== Winners ========");
		Collections.sort(coins, new PlayerComparator());
		for (final Coin coin : coins) {
			print(coin);
		}
	}

	private static class PlayerComparator implements Comparator<Coin> {

		@Override
		public int compare(final Coin o1, final Coin o2) {
			return o1.getMoves() - o2.getMoves();
		}

	}

	private void err(final Object msg) {
		System.err.println(msg.toString());
	}

	private void log(final Object msg) {
		System.out.println(msg.toString());
	}

	private void print(final Object msg) {
		System.out.println(msg.toString());
	}
}
