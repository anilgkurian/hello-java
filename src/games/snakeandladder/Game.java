package games.snakeandladder;

import java.util.Collections;
import java.util.Comparator;

/**
 * An instance of a game which has a board and
 *
 * @author Anil Kurian
 *
 */
public class Game {

	private final Board board;

	public Game(final Board board) {
		this.board = board;
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
		final Node newNode = board.getNodes().get(newPos - 1);

		if (checkForSnakes(coin, newNode)) {
			return true;
		}

		if (checkForLadder(coin, newNode)) {
			return true;
		}

		moveCoin(coin, newNode);
		log(coin.getPlayer() + " moved by " + pos + " to reach " + newNode.getNumber());

		if (coin.getPosition().getNumber() == 100) {
			for (final Coin othercoin : board.getCoins()) {
				if (othercoin.getPosition().getNumber() != 100) {
					return true;
				}
			}
			printSummery();
			return false;
		}
		return true;
	}

	private boolean checkForLadder(final Coin coin, final Node newNode) {
		for (final AddOn ladder : board.getLadders()) {
			if (ladder.getTailPosition().equals(newNode)) {
				final Node headPosition = ladder.getHeadPosition();
				moveCoin(coin, headPosition);
				coin.ladderChance();
				log(coin.getPlayer() + " got ladder at " + newNode.getNumber() + ". moved to "
						+ ladder.getHeadPosition());
				return true;
			}
		}
		return false;
	}

	private boolean checkForSnakes(final Coin coin, final Node newNode) {
		for (final AddOn snake : board.getSnakes()) {
			if (snake.getHeadPosition().equals(newNode)) {
				final Node tailPosition = snake.getTailPosition();
				moveCoin(coin, tailPosition);
				coin.snakeBite();
				log(coin.getPlayer() + " snake bite at " + newNode.getNumber() + ". moved to "
						+ snake.getTailPosition());
				return true;
			}
		}
		return false;
	}

	public void printSummery() {
		print("\n======== Winners ========");
		Collections.sort(board.getCoins(), new PlayerComparator());
		for (final Coin coin : board.getCoins()) {
			print(coin);
		}
	}

	private static class PlayerComparator implements Comparator<Coin> {

		@Override
		public int compare(final Coin o1, final Coin o2) {
			return o1.getMoves() - o2.getMoves();
		}

	}

	private void moveCoin(final Coin coin, final Node tailPosition) {
		coin.getPosition().getNumber();
		coin.setPosition(tailPosition);
		coin.getPosition().getNumber();
	}

	public static void err(final Object msg) {
		System.err.println(msg.toString());
	}

	public static void log(final Object msg) {
		System.out.println(msg.toString());
	}

	public static void print(final Object msg) {
		System.out.println(msg.toString());
	}
}
