package games.snakeandladder;

public class Dice {

	public static int flip() {
		return (int) ((Math.random()*100)%6 + 1);
	}
	
}
