package datastructure.array;

import java.util.Arrays;

public class OddEven {

	private static int[] input = new int[] { 3, 5, 6, 2, 4, 656, 35, 33, 55 };

	public static void main(String[] a) {

		ArrangeOddAndEven(input);
		System.out.println(Arrays.toString(input));
	}

	static void ArrangeOddAndEven(int[] arr) {
		int oddIndex = 0;
		int evenIndex = 1;
		while (oddIndex <= arr.length - 2 && evenIndex <= arr.length - 1) {
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

	private static void swap(int[] arr, int oddIndex, int evenIndex) {
		int temp = arr[oddIndex];
		arr[oddIndex] = arr[evenIndex];
		arr[evenIndex] = temp;
	}

	private static boolean isOddNumber(int num) {
		return num % 2 == 1;
	}

	private static boolean isEvenNumber(int num) {
		return num % 2 == 0;
	}
}
