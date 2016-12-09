package datastructure.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Finding duplicates in array. O(n)
 * 
 * @author Anil Kurian
 *
 */
public class DuplicateInArray {

	private static int[] array = new int[] { 1, 32, 4, 6, 3, 4, 1, 2, 34, 5, 5, 5, 4 };

	public static void main(final String... args) {

		findDuplicateUsingMap();
		printRepeatingUsingArray();
	}

	private static void findDuplicateUsingMap() {
		final Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (final int i : array) {
			Integer number = map.get(i);
			map.put(i, number == null ? 1 : ++number);
		}

		for (final int i : map.keySet()) {
			final Integer integer = map.get(i);
			if (integer > 1) {
				System.out.println("Duplicate: " + i + ", no. of duplicates " + map.get(i));
			}
		}
	}

	private static void printRepeatingUsingArray() {

		final int size = getMaxNum(array);
		final int count[] = new int[size];
		int i;

		System.out.println("Repeated elements are : ");
		for (i = 0; i < array.length; i++) {
			if (count[array[i]] == 1) {
				System.out.print(array[i] + " ");
				count[array[i]] = 0;
			} else {
				count[array[i]] = count[array[i]] + 1;
			}
		}
	}

	private static int getMaxNum(final int arr[]) {
		int num = arr[0];

		for (final int element : arr) {
			if (num < element) {
				num = element;
			}
		}
		return num + 1;
	}
}
