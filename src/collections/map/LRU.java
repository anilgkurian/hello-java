package collections.map;

import java.util.LinkedList;

public class LRU {

	private static int[] numbers = { 34, 5, 76, 2, 86, 3, 44684, 2, 1, 12, 45 };

	private static int size = numbers.length;
	
	private static LinkedList<Integer> q = new LinkedList<>();
	
	public static void main(String... args) {

		for (int num : numbers) {
			q.add(num);
		}

		get(86);
		get(2);
		put(14);
	}

	private static void get(int key) {
		if(q.contains(key)) {
			int indexOf = q.indexOf(key);
			q.remove(indexOf);
			q.addFirst(key);
		}
		System.out.println(q);
	}

	private static void put(int key) {
		if(q.size()==size) {
			q.removeLast();
		}
		q.addFirst(key);
		System.out.println(q);
	}

}

