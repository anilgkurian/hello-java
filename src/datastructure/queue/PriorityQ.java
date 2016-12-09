package datastructure.queue;

import java.util.PriorityQueue;

/**
 * Polling a priority Q returns the elements in their natural ascending order,
 * not based on insertion order.
 *
 * @author Anil Kurian
 *
 */
public class PriorityQ {

	public static void main(final String[] arg) {

		final PriorityQueue<Integer> q = new PriorityQueue<>();

		q.add(43);
		q.add(23);
		q.add(223);
		q.add(2);

		System.out.println(q);

		Integer e = q.poll();
		while (e != null) {
			System.out.println(e);
			e = q.poll();
		}

	}

}
