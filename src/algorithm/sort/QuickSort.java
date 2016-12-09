package algorithm.sort;

import java.util.Arrays;

/**
 * @author Anil Kurian
 *
 */
public class QuickSort {
	private static int[] input = { 34, 5, 76, 2, 86, 3, 44684, 2, 1, 12, 45 };

	public static void main(final String... args) {
		final int size = input.length;
		quicksort(0, size - 1);

		System.out.println(Arrays.toString(input));
	}

	private static void quicksort(final int low, final int high) {

		int i = low, j = high;
		final int pivot = input[low + ((high - low) / 2)];

		while (i <= j) {

			while (input[i] < pivot) {
				i++;
			}
			while (input[j] > pivot) {
				j--;
			}

			if (i <= j) {
				swap(i, j);
				i++;
				j--;
			}
		}

		if (low < j) {
			quicksort(low, j);
		}
		if (i < high) {
			quicksort(i, high);
		}

	}

	private static void swap(final int i, final int j) {
		final int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}
