package datastructure.stack;

import java.util.Arrays;

/**
 * Implementing two stacks using a single array by dividing the array into. Not
 * dividing the array into two but whichever stack getting filled fast will
 * occupy more of the array.
 *
 * @author Anil Kurian
 *
 * @param <E>
 */
public class TwoStacksWithOneArray<E> {

	private final E[] array;

	private final int size;

	private int stack1Pointer;

	private int stack2Pointer;

	public void push1(final E e) {
		if (isStackFull()) {
			System.out.println("Full");
		} else {
			array[stack1Pointer++] = e;
		}
	}

	public void push2(final E e) {
		if (isStackFull()) {
			System.out.println("Full");
		} else {
			array[stack2Pointer--] = e;
		}
	}

	public E pop1() {
		if ((stack1Pointer - 1) < 0) {
			System.out.println("No elements");
			System.exit(0);
		}
		stack1Pointer--;
		return array[stack1Pointer];
	}

	public E pop2() {
		if ((stack2Pointer + 1) == size) {
			System.out.println("No elements");
			System.exit(0);
		}
		stack2Pointer++;
		return array[stack2Pointer];
	}

	public boolean isStack1Empty() {
		return stack1Pointer == 0;
	}

	public boolean isStack2Empty() {
		return stack2Pointer == (size - 1);
	}

	public void printStacks() {
		System.out.println(Arrays.toString(array));
	}

	private boolean isStackFull() {
		return stack1Pointer == stack2Pointer;
	}

	public TwoStacksWithOneArray() {
		size = 10;
		array = (E[]) new Object[size];
		stack1Pointer = 0;
		stack2Pointer = size - 1;
	}

	public static void main(final String[] args) {
		final TwoStacksWithOneArray<Integer> stack = new TwoStacksWithOneArray<Integer>();
		for (int i = 1; i <= 6; i++) {
			stack.push1(i);
		}
		stack.printStacks();

		for (int i = 101; i <= 105; i++) {
			stack.push2(i);
		}
		stack.printStacks();

		System.out.println("Stack 1");
		while (!stack.isStack1Empty()) {
			System.out.println(stack.pop1());
		}

		System.out.println("Stack 2");
		while (!stack.isStack2Empty()) {
			System.out.println(stack.pop2());
		}
	}
}