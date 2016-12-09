package datastructure.array;

import java.util.Arrays;

/**
 * @author Anil Kurian 
 * Keep all odd numbers first
 */
public class OddFirst {

	private static int[] input = new int[] { 2, 3, 5, 6, 2, 4, 656, 35, 33, 55 };

	public static void main(final String[] a) {

		ArrangeOddAndEven(input);
		System.out.println(Arrays.toString(input));
	}

	static void ArrangeOddAndEven(final int[] items) {
		int evenPos, nextOddPos;
		for (nextOddPos = 0; (nextOddPos < items.length) && ((items[nextOddPos] % 2) != 0); nextOddPos++) {
		}
		System.out.println(nextOddPos);

		for (evenPos = nextOddPos + 1; evenPos < items.length; evenPos++) {
			if (isOddNumber(items[evenPos])) {
				swap(items, evenPos, nextOddPos);
				nextOddPos++;
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
}
