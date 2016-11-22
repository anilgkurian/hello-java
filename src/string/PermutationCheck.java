package string;
import java.util.ArrayList;
import java.util.List;

public class PermutationCheck {


	public static void main(String[] ar) {
		permutation("anil");
	}
	public static void permutation(String str) { 
	    List<String> permutation = permutation("", str, new ArrayList<String>()); 
	    
	    System.out.println(permutation.contains("asdf"));
	    System.out.println(permutation.contains("ilan"));
	}

	public static List<String> permutation(String prefix, String str, ArrayList<String> list) {
		System.out.println("Pre: "+prefix + " \tstr: "+str);
	    int n = str.length();
	    if (n == 0) {
	    	System.out.println(prefix+" -------");
	    	list.add(prefix);
	    }
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n),list);
	    }
	    return list;
	}


}
