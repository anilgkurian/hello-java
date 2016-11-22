package games.snakeandladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Board {

	private static List<Node> nodes = new ArrayList<Node>();

	private static List<Snake> snakes = new ArrayList<Snake>();
	
	private static List<Ladder> ladders = new ArrayList<Ladder>();
	
	private static List<Coin> coins = new ArrayList<Coin>();
	
	private Set<Integer> nodeOfActions = new HashSet<Integer>();

	private static List<String> board = new ArrayList<String>();

	public Board() {
		for (int i = 1; i <= 100; i++) {
			Node n = new Node(i);
			nodes.add(n);
		}
	}
	
	static{
		for(int i=1; i<=100;i++) {
			board.add(""+i);
		}
	}
	
	public Board addPlayer(String name) {
		coins.add(new Coin(nodes.get(0), name));
		return this;
	}
	
	public List<Coin> getCoins(){
		return coins;
	}
	
	public Board addSnake(int head, int tail) {
		if(tail>=head || !nodeOfActions.add(head) || !nodeOfActions.add(tail)) {
			err("Snake ignored "+head+","+tail);
			return this;
		}
		snakes.add(new Snake(nodes.get(head), nodes.get(tail)));
		return this;
	}
	
	public Board addLadder(int head, int tail) {
		if(tail>=head || !nodeOfActions.add(head) || !nodeOfActions.add(tail)) {
			err("Ladder ignored "+head+","+tail);
			return this;
		}
		ladders.add(new Ladder(nodes.get(head), nodes.get(tail)));
		return this;
	}
	
	public boolean move( Coin coin, int pos) {
//		printBoard();
		if(coin.getPosition().getNumber()==100) {
			return true;
		}
		coin.incrementMoves();
		
		Node currentNode = coin.getPosition();
		int newPos = currentNode.getNumber()+pos;
		if(newPos>100) {
			log("new position is above 100");
			return true;
		}
		
		log(coin.getPlayer() + " moved by "+pos);
		Node newNode = nodes.get(newPos-1);
		
		for(Snake snake:snakes) {
			if(snake.getHeadPosition().equals(newNode)) {
				Node tailPosition = snake.getTailPosition();
				moveCoin(coin, tailPosition);
				coin.snakeBite();
				log(coin.getPlayer() + " snake bite at "+newNode.getNumber()+". moved to "+snake.getTailPosition());
				return true;
			}
		}
		
		for(Ladder ladder:ladders) {
			if(ladder.getTailPosition().equals(newNode)) {
				Node headPosition = ladder.getHeadPosition();
				moveCoin(coin, headPosition);
				coin.ladderChance();
				log(coin.getPlayer() + " got ladder at "+newNode.getNumber()+". moved to "+ladder.getHeadPosition());
				return true;
			}
		}
		moveCoin(coin, newNode);
		log(coin.getPlayer() + " moved by "+pos+ " to reach "+newNode.getNumber());
		
		if(coin.getPosition().getNumber()==100) {
			for(Coin othercoin:coins) {
				if(othercoin.getPosition().getNumber()!=100) {
					return true;
				}
			}
			printSummery();
			return false;
		}
		return true;
	}

	private void moveCoin(Coin coin, Node tailPosition) {
		int curBoardPos = coin.getPosition().getNumber()-1;
		board.set(curBoardPos, coin.getPosition().getNumber()+"");
		coin.setPosition(tailPosition);
		int newPos = coin.getPosition().getNumber()-1;
//		Integer.parseInt(board.get(newPos))
		board.set(newPos, coin.getPlayer());
	}
	
	public void printSummery() {
		print("\n======== Winners ========");
		Collections.sort(coins,new PlayerComparator());
		for(Coin coin:coins) {
			print(coin);
		}
	}
	
	private static class PlayerComparator implements Comparator<Coin>{

		@Override
		public int compare(Coin o1, Coin o2) {
			return o1.getMoves() - o2.getMoves();
		}
		
	}

	private void err(Object msg) {
		System.err.println(msg.toString());
	}
	private void log(Object msg) {
		System.out.println(msg.toString());
	}
	
	private void print(Object msg) {
		System.out.println(msg.toString());
	}
	
	
	private void printBoard() {
		System.out.println("\n\n");
		for(int i=0;i<100;i++) {
			if((i)%10==0) {
				System.out.println();
			}
			System.out.print(board.get(i) +"\t");
		}
	}
}
