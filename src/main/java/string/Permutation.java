package string;

/**
 * All Permutation of chars in a given string
 *
 * @author Anil Kurian
 *
 */
public class Permutation {

	public static void main(final String[] ar) {
		permutation("anil");
	}

	public static void permutation(final String str) {
		permutation("", str);
	}

	public static void permutation(final String prefix, final String str) {

		final int n = str.length();
		if (n == 0) {
			System.out.println(prefix);
		} else {
			for (int i = 0; i < n; i++) {
				permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
			}
		}
	}
}