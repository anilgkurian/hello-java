package string;
public class Permutation {

	public static void main(String[] ar) {
		permutation("anil");
	}
	public static void permutation(String str) { 
	    permutation("", str); 
	}

	public static void permutation(String prefix, String str) {
		
		System.out.println("\t "+prefix + "\t "+str);
	    int n = str.length();
	    if (n == 0) {
	    	System.out.println(prefix+" -------");
	    }
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
}