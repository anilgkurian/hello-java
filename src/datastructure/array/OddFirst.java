package datastructure.array;

import java.util.Arrays;

public class OddFirst {

	private static int[] input = new int[] { 2, 3, 5, 6, 2, 4, 656, 35, 33, 55 };

	public static void main(String[] a) {

		ArrangeOddAndEven(input);
		System.out.println(Arrays.toString(input));
	}

	static void ArrangeOddAndEven(int[] items) {
		 int evenPos, nextOddPos;
		    for (nextOddPos = 0; 
		    		nextOddPos < items.length && items[nextOddPos] % 2 != 0;
		         nextOddPos++) { }
		    System.out.println(nextOddPos);
		    

		    for (evenPos = nextOddPos + 1; evenPos < items.length; evenPos++)
		    {
		        if (items[evenPos] % 2 != 0)
		        {
		            swap(items, evenPos, nextOddPos);
		            nextOddPos++;
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
