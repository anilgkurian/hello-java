package datastructure.queue;

/**
 * Implementing a queue with Array
 *
 * @author Anil Kurian
 *
 * @param <E>
 */
public class QueueWithArray<E> implements Queue<E> {

	private final E[] array;

	private final int size;

	private int frontPointer;

	private int rearPointer;

	@Override
	public void add(final E e) {
		if (rearPointer < size) {
			array[rearPointer++] = e;
		} else {
			System.out.println("Full");
		}
	}

	@Override
	public E pop() {
		if (frontPointer == size) {
			System.out.println("No elements");
			System.exit(0);
		}
		final E e = array[frontPointer];
		frontPointer++;
		return e;
	}

	public QueueWithArray() {
		size = 10;
		array = (E[]) new Object[size];
	}

	public static void main(final String[] args) {
		final QueueWithArray<Integer> queue = new QueueWithArray<Integer>();
		for (int i = 0; i < 10; i++) {
			queue.add(i);
		}

		while (true) {
			System.out.println(queue.pop());
		}
	}

}
