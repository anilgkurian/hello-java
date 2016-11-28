package datastructure.stack;

import java.util.LinkedList;

public class StackWithLinkedList<E> implements Stack<E>{

	private LinkedList<E> list = new LinkedList<E>();
	
	@Override
	public void push(E e) {
		list.addFirst(e);
	}

	@Override
	public E pop() {
		return list.remove();
	}
	
	public static void main(String[] args) {
		Stack<Object> stack = new StackWithLinkedList<>();
		
		for(int i=0;i<10;i++) {
			stack.push(i);
		}
		
		Object pop = stack.pop();
		while(pop!=null) {
			System.out.println(pop);
			pop = stack.pop();
		}		
	}

	
}
