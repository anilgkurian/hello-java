package algorithm.sort;

import java.util.Arrays;


// choose a pivot, divide and sort
public class Quicksort  {
    private static int[] numbers = {34,5,76,2,86,3,44684,2,1,12,45};
    private static int number;

    public static void main(String... args) {
            number = numbers.length;
            quicksort(0, number - 1);
            
            System.out.println(Arrays.toString(numbers));
    }

    private static void quicksort(int low, int high) {
            int i = low, j = high;
            // Get the pivot element from the middle of the list
            int pivot = numbers[low + (high-low)/2];

            // Divide into two lists
            while (i <= j) {
                    // If the current value from the left list is smaller then the pivot
                    // element then get the next element from the left list
                    while (numbers[i] < pivot) {
                            i++;
                    }
                    // If the current value from the right list is larger then the pivot
                    // element then get the next element from the right list
                    while (numbers[j] > pivot) {
                            j--;
                    }

                    // If we have found a values in the left list which is larger then
                    // the pivot element and if we have found a value in the right list
                    // which is smaller then the pivot element then we exchange the
                    // values.
                    // As we are done we can increase i and j
                    if (i <= j) {
                            exchange(i, j);
                            i++;
                            j--;
                    }
            }
            // Recursion
            if (low < j)
                    quicksort(low, j);
            if (i < high)
                    quicksort(i, high);
    }

    private static void exchange(int i, int j) {
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
    }
}
