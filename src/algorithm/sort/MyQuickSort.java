package algorithm.sort;

import java.util.Arrays;

public class MyQuickSort {
	private static int[] numbers = {34,5,76,2,86,3,44684,2,1,12,45};
    private static int size;

    public static void main(String... args) {
            size = numbers.length;
            quicksort(0, size - 1);
            
            System.out.println(Arrays.toString(numbers));
    }

    private static void quicksort(int low, int high) {
    	
    	int i =low, j = high;
    	int pivot = numbers[low + (high-low)/2];    	
    	
    	while(i<=j) {
    		
    		while(numbers[i]<pivot) {
    			i++;
    		}
    		while(numbers[j]>pivot) {
    			j--;
    		}
    		
    		if(i<=j) {
    			swap(i,j);
    			i++;
    			j--;
    		}
    	}
    	
    	if(low<j)
    		quicksort(low, j);
    	if(i<high)
    		quicksort(i, high);
    	
    }

	private static void swap(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
