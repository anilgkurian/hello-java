package datastructure.set;

import java.util.HashSet;

/**
 * Find pairs of numbers which when added together gives the sum inputted.
 *
 * @author Anil Kurian
 *
 */
public class FindPairs {

	public static void main(final String[] args) {

		final int A[] = { 11, 4, 45, 6, 10, 9, 5, 13 };

		final int sum = 16;

		final HashSet<Integer> set = new HashSet<Integer>();

		for (final int e : A) {
			if (set.contains(sum - e)) {
				System.out.println(e + "," + (sum - e));
				set.remove(sum - e);
			} else {
				set.add(e);
			}
		}
	}
}
