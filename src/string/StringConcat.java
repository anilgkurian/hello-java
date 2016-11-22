package string;

public class StringConcat {

	public static void main(String... ar) {
		
		String s = "anilgkurian";
		String s2 = new String("anilgkurian").intern();
		
		System.out.println(s==s2);
				
	}
}
