package datastructure.queue;

import java.util.LinkedList;

/**
 * Implementing a queue with LinkedList
 *
 * @author Anil Kurian
 *
 * @param <E>
 */
public class QueueWithLinkedList<E> implements Queue<E> {

	private final LinkedList<E> list = new LinkedList<E>();

	@Override
	public void add(final E e) {
		list.addFirst(e); // doing same as offer & add
	}

	@Override
	public E pop() {
		try {
			return list.removeLast(); // same as pop & remove
		} catch (final Exception e) {
		}
		return null;
	}

	public static void main(final String[] args) {
		final Queue<Integer> queue = new QueueWithLinkedList<>();

		for (int i = 0; i < 10; i++) {
			queue.add(i);
		}

		Integer pop = queue.pop();
		while (pop != null) {
			System.out.println(pop);
			pop = queue.pop();
		}
	}

}
