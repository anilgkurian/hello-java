package games.snakeandladder;

import java.util.List;

public class StartGame {

	public static void main(final String[] args) {

		final Board board = new Board().addPlayer("Anil").addPlayer("Sarah").addPlayer("Lima").addPlayer("Leon");
		addSnakesAndLaddersInBoard(board);

		final Game game = new Game(board);

		final List<Coin> coins = board.getCoins();

		int i = 0;
		final long startTime = System.currentTimeMillis();
		boolean gameOn = true;
		while (gameOn) {
			final Coin coin = coins.get(i);
			if (coin.getPosition().getNumber() != 100) {
				final int flip = Dice.flip();
				gameOn = game.move(coin, flip);
			}
			i++;
			i = i >= coins.size() ? 0 : i;
		}

		final long endTime = System.currentTimeMillis();
		System.out.println("Time taken " + (endTime - startTime));

	}

	private static void addSnakesAndLaddersInBoard(final Board board) {
		board.addSnake(14, 8).addSnake(10, 1).addSnake(97, 4).addSnake(32, 12).addSnake(55, 38).addSnake(78, 30)
				.addSnake(98, 29).addSnake(88, 49).addSnake(89, 51);
		board.addLadder(15, 2).addLadder(35, 20).addLadder(25, 11).addLadder(75, 45).addLadder(95, 72);
	}
}