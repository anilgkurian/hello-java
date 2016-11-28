package datastructure.queue;
import java.util.PriorityQueue;

public class PriorityQ {

	public static void main(String[] arg) {
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		q.add(43);
		q.add(23);
		q.add(223);
		q.add(2);
		
		System.out.println(q);
		Integer e = q.remove();
		while(e!=null) {
			System.out.println(e);
			e=q.remove();
		}
		
	}

}
