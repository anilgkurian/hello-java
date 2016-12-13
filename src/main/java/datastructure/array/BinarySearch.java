package datastructure.array;

/**
 * @author Anil Kurian
 *
 */
public class BinarySearch {

	private static int input[] = { 2, 3, 4, 10, 40 };

	private int binarySearch(final int arr[], final int low, final int high, final int elem) {
		if (high >= low) {
			final int mid = low + ((high - low) / 2);

			if (arr[mid] == elem) {
				return mid;
			}

			if (arr[mid] > elem) {
				return binarySearch(arr, low, mid - 1, elem);
			} else {
				return binarySearch(arr, mid + 1, high, elem);
			}
		}

		return -1;
	}

	public static void main(final String args[]) {
		final BinarySearch ob = new BinarySearch();
		final int n = input.length;
		final int x = 10;
		final int result = ob.binarySearch(input, 0, n - 1, x);
		if (result == -1) {
			System.out.println("Element not present");
		} else {
			System.out.println("Element found at index " + result);
		}
	}
}