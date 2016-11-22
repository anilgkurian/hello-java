package games.snakeandladder;

import java.util.List;
import java.util.Map;

public class Game {

	public static void main(String[] args) {
		
		Board board = new Board().addPlayer("Anil").addPlayer("Sarah").addPlayer("Lima").addPlayer("Leon");
		Map a;
		addSnakesAndLadders(board);
		
		List<Coin> coins = board.getCoins();
		
		int i =0;
		long startTime = System.currentTimeMillis();
		boolean gameOn = true;
		while(gameOn) {
			Coin coin = coins.get(i);
			if(coin.getPosition().getNumber()!=100) {
				int flip = Dice.flip();
				gameOn = board.move(coin, flip);
			}
			i++;
			i= i>=coins.size()?0:i;
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken "+(endTime-startTime));
		
	}

	private static void addSnakesAndLadders(Board board) {
		board.addSnake(14,8).addSnake(10, 1).addSnake(97, 4).addSnake(32, 12)
			.addSnake(55,38).addSnake(78, 30).addSnake(98, 29).addSnake(88, 49).addSnake(89, 51);
		board.addLadder(15,2).addLadder(35, 20).addLadder(25,11).addLadder(75, 45).addLadder(95,72);
	}

	private static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}