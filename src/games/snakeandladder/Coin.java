package games.snakeandladder;

/**
 * Represents a coin/player with its current position
 *
 * @author Anil Kurian
 *
 */
public class Coin implements Comparable<Coin> {

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

	public void setPosition(final Node position) {
		this.position = position;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(final String player) {
		this.player = player;
	}

	public Coin(final Node position, final String player) {
		super();
		this.position = position;
		this.player = player;
	}

	@Override
	public String toString() {
		return player + ":\t moves=" + moves + ",\t snake bites=" + snakeBites + ",\t ladders=" + ladderChances;
	}

	public int getMoves() {
		return moves;
	}

	public void setMoves(final int moves) {
		this.moves = moves;
	}

	@Override
	public int compareTo(final Coin o) {
		return moves = o.getMoves();
	}

	public int getSnakeBites() {
		return snakeBites;
	}

	public void setSnakeBites(final int snakeBites) {
		this.snakeBites = snakeBites;
	}

	public int getLadderChances() {
		return ladderChances;
	}

	public void setLadderChances(final int ladderChances) {
		this.ladderChances = ladderChances;
	}
}
