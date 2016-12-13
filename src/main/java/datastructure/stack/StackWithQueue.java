package datastructure.stack;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * TODO: not complete
 * 
 * @author Anil Kurian
 *
 */
public class StackWithQueue {

	private LinkedList<Integer> q1 = new LinkedList<Integer>();
	private LinkedList<Integer> q2 = new LinkedList<Integer>();

	private int pop() {
		return q2.pop();
	}

	private void push(final int e) {
		q2.push(e);

		final Iterator<Integer> iterator = q1.iterator();
		while (iterator.hasNext()) {
			q2.push(iterator.next());
		}

		final LinkedList<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
	}

	public static void main(final String... arg) {
		final StackWithQueue ob = new StackWithQueue();
		for (int i = 0; i < 10; i++) {
			ob.push(i);
		}

		while (true) {
			System.out.println(ob.pop());
		}
	}
}
