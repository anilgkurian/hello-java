package datastructure.set;
import java.util.HashSet;

public class FindPairs {

	public static void main(String[] args) {
		
		int A[] = {1, 4, 45, 6, 10, 9,10,6};
	    int sum = 16;
	    
	    HashSet<Integer> set = new HashSet<Integer>();
	    
	    for (int e : A) {
	        if (set.contains(sum-e)) {
	            System.out.println(e + "," + (sum-e));
	            // deal with the duplicated case
	            set.remove(sum-e);
	            System.out.println("removed "+(sum-e)+" - "+set);
	        } else {
	            set.add(e);
	            System.out.println("added "+e+" - "+set);
	        }
	    }
	}
}
