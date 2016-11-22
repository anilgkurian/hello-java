package games.snakeandladder;

public class Node implements Comparable<Integer>{

	
	private Integer number;

	
	/**
	 * @param num
	 */
	public Node(Integer num) {
		number = num;
	}

	@Override
	public int compareTo(Integer o) {
		return this.number.compareTo(o);
	}

	@Override
	public String toString() {
		return ""+number;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	
}
