package games.snakeandladder;

public class Coin implements Comparable<Coin>{

	private String player;
	
	private int moves;

	private int snakeBites;
	
	private int ladderChances;
	
	private Node position;
	
	
	public void incrementMoves() {
		moves++;
	}
	
	public void snakeBite() {
		snakeBites++;
	}

	public void ladderChance() {
		ladderChances++;
	}
	public Node getPosition() {
		return position;
	}

	public void setPosition(Node position) {
		this.position = position;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public Coin(Node position, String player) {
		super();
		this.position = position;
		this.player = player;
	}

	@Override
	public String toString() {
		return  player + ":\t moves=" + moves+ ",\t snake bites=" + snakeBites+ ",\t ladders=" + ladderChances;
	}

	public int getMoves() {
		return moves;
	}

	public void setMoves(int moves) {
		this.moves = moves;
	}

	@Override
	public int compareTo(Coin o) {
		return moves = o.getMoves();
	}

	public int getSnakeBites() {
		return snakeBites;
	}

	public void setSnakeBites(int snakeBites) {
		this.snakeBites = snakeBites;
	}

	public int getLadderChances() {
		return ladderChances;
	}

	public void setLadderChances(int ladderChances) {
		this.ladderChances = ladderChances;
	}
}
