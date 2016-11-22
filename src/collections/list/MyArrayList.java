package collections.list;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyArrayList extends ArrayList<Integer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		
		List<Integer> list = new MyArrayList();
		
		for(int i=0;i<10;i++) {
			list.add(i);
		}

		Iterator<Integer> iterator = list.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}
}
