package algorithm.sort;

import java.util.Arrays;

public class BubbleSort {
	private static int[] numbers = {34,5,76,2,86,3,44684,2,1,12,45};

    public static void main(String... args) {
            bubbleSort(numbers);
            
            System.out.println(Arrays.toString(numbers));
    }

    private static void bubbleSort(int[] numbers) {
    
    	boolean swapped = false;

    	do{
    		swapped = false;
	    	for(int i=0;i<numbers.length-1;i++) {
					if(numbers[i]>numbers[i+1]) {
						swap(numbers, i);
						swapped = true;
					}
	    	}
    	}while(swapped);
    }

	private static void swap(int[] numbers, int i) {
		int temp = numbers[i];
		numbers[i] = numbers[i+1];
		numbers[i+1] = temp;
	}

}
