package games.snakeandladder;

/**
 * Represents a single node in the SnL board
 * 
 * @author Anil Kurian
 *
 */
public class Node implements Comparable<Integer> {

	private Integer number;

	/**
	 * @param num
	 */
	public Node(final Integer num) {
		number = num;
	}

	@Override
	public int compareTo(final Integer o) {
		return number.compareTo(o);
	}

	@Override
	public String toString() {
		return "" + number;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(final Integer number) {
		this.number = number;
	}

}
