package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Checks if a given string is one of the permutation of chars of another
 * string.
 *
 * @author Anil Kurian
 */
public class PermutationCheck {

	public static void main(final String[] ar) {
		permutation("anil");
	}

	public static void permutation(final String str) {
		final List<String> permutation = permutation("", str, new ArrayList<String>());

		System.out.println(permutation.contains("asdf"));
		System.out.println(permutation.contains("ilan"));
	}

	public static List<String> permutation(final String prefix, final String str, final ArrayList<String> list) {
		final int n = str.length();
		if (n == 0) {
			list.add(prefix);
		} else {
			for (int i = 0; i < n; i++) {
				permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), list);
			}
		}
		return list;
	}

}
