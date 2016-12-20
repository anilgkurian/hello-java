package algorithm.sort;

import java.util.Arrays;

/**
 * Keep swapping all elements till no more swapping is required. O(n2)
 * 
 * @author Anil Kurian
 */
public class BubbleSort {
	private static int[] input = { 34, 5, 76, 2, 86, 3, 44684, 2, 1, 12, 45 };

	public static void main(final String... args) {
		bubbleSort(input);

		System.out.println(Arrays.toString(input));
	}

	private static void bubbleSort(final int[] numbers) {

		boolean swapped = false;

		do {
			swapped = false;
			for (int i = 0; i < (numbers.length - 1); i++) {
				if (numbers[i] > numbers[i + 1]) {
					swap(numbers, i);
					swapped = true;
				}
			}
		} while (swapped);
	}

	private static void swap(final int[] numbers, final int i) {
		final int temp = numbers[i];
		numbers[i] = numbers[i + 1];
		numbers[i + 1] = temp;
	}

}
