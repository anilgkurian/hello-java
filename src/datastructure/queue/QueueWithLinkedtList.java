package datastructure.queue;

import java.util.LinkedList;

public class QueueWithLinkedtList<E> implements Queue<E> {

	private LinkedList<E> list = new LinkedList<E>();
	
	@Override
	public void add(E e) {
		list.add(e); // doing same as offer
	}

	@Override
	public E pop() {
		return list.remove(); // same as pop	
	}

	@Override
	public E peek() {
		return list.peek();
	}
	
	public static void main(String[] args) {
		Queue<Object> queue = new QueueWithLinkedtList<>();
		
		for(int i=0;i<10;i++) {
			queue.add(i);
		}
		
		
		Object pop = queue.pop();
		while(pop!=null) {
			System.out.println(pop);
			pop = queue.pop();
		}		
	}

}
