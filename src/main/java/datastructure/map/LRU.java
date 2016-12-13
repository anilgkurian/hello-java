package datastructure.map;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Least Recently used cache.
 *
 * TODO: improve
 * 
 * @author Anil Kurian
 *
 */
public class LRU {

	private final Map<Integer, String> cache = new HashMap<Integer, String>();

	private static int size = 5;

	private static LinkedList<Integer> q = new LinkedList<>();

	public static void main(final String... args) {

		final LRU lru = new LRU();

		lru.put(34, "34");
		lru.put(3, "3");
		lru.put(10, "10");
		lru.put(23, "22");
		lru.put(76, "76");
		lru.put(40, "40");
		lru.put(12, "12");

		lru.get(76);

	}

	public String get(final int key) {
		String value = null;
		final int indexOfKey = q.indexOf(key);
		if (indexOfKey >= 0) {
			q.remove(indexOfKey);
			q.addFirst(key);
			value = cache.get(key);
			System.out.println("Moving to top " + key);
		}
		System.out.println(q);
		return value;
	}

	public void put(final int key, final String value) {
		if (q.size() == size) {
			System.out.println("Cache full, removing least used");
			q.removeLast();
		}
		q.addFirst(key);
		cache.put(key, value);
		System.out.println(q);
	}

}
