package collections.stack;

public class StackWithArray<E> implements Stack<E>{
	
	private E[] array ;
	
	private int size;
	
	private int pointer;
	
	@Override
	public E pop() {
		if(pointer-1<0) {
			System.out.println("No elements");
			System.exit(0);
		}
		pointer--;
		return array[pointer];
	}
	
	@Override
	public void push(E n) {
		if(pointer<size) {
			array[pointer++]= n;
		}else {
			System.out.println("Full");
		}
	}
	
	public StackWithArray() {
		size = 10;
		array = (E[]) new Object[size]; 
	}
	
	public static void main(String[] args) {
		StackWithArray stack = new StackWithArray();
		for(int i=0;i<10;i++) {
			stack.push(i);
		}
		
		while(true) {
			System.out.println(stack.pop());
		}
	}

}
