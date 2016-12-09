package datastructure.array;

import java.util.Arrays;

/**
 * @author Anil Kurian
 * Keeps odd and even number alternatively
 */
public class OddEven {

	private static int[] input = new int[] { 3, 5, 6, 2, 4, 656, 35, 33, 55 };

	public static void main(final String[] a) {

		ArrangeOddAndEven(input);
		System.out.println(Arrays.toString(input));
	}

	static void ArrangeOddAndEven(final int[] arr) {
		int oddIndex = 0;
		int evenIndex = 1;
		while ((oddIndex <= (arr.length - 2)) && (evenIndex <= (arr.length - 1))) {
			System.out.println(Arrays.toString(input));

			if (isOddNumber(arr[oddIndex])) {
				oddIndex = oddIndex + 2;
			} else {
				if (isEvenNumber(arr[evenIndex])) {
					evenIndex = evenIndex + 2;
				} else {
					swap(arr, oddIndex, evenIndex);
				}
			}
		}
	}

	private static void swap(final int[] arr, final int oddIndex, final int evenIndex) {
		final int temp = arr[oddIndex];
		arr[oddIndex] = arr[evenIndex];
		arr[evenIndex] = temp;
	}

	private static boolean isOddNumber(final int num) {
		return (num % 2) == 1;
	}

	private static boolean isEvenNumber(final int num) {
		return (num % 2) == 0;
	}
}
