package games.snakeandladder;

/**
 * The Dice which gives 1-6 randomly
 *
 * @author Anil Kurian
 *
 */
public class Dice {

	public static int flip() {
		return (int) (((Math.random() * 100) % 6) + 1);
	}

}
