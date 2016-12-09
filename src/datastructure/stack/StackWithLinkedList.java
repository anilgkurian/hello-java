package datastructure.stack;

import java.util.LinkedList;

/**
 * @author Anil Kurian
 *
 * @param <E>
 */
public class StackWithLinkedList<E> implements Stack<E> {

	private final LinkedList<E> list = new LinkedList<E>();

	@Override
	public void push(final E e) {
		list.addFirst(e);
	}

	@Override
	public E pop() {
		return list.removeFirst();
	}

	public static void main(final String[] args) {
		final Stack<Object> stack = new StackWithLinkedList<>();

		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}

		Object pop = stack.pop();
		while (pop != null) {
			System.out.println(pop);
			pop = stack.pop();
		}
	}

}
