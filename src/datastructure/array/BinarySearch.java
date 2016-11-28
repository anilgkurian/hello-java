package datastructure.array;

public class BinarySearch {
 // Returns index of x if it is present in arr[l..r], else
 // return -1
 int binarySearch(int arr[], int low, int high, int elem)
 {
     if (high>=low)
     {
         int mid = low + (high - low)/2;

         if (arr[mid] == elem)
            return mid;

         if (arr[mid] > elem){
            return binarySearch(arr, low, mid-1, elem);
         }else{
        	 return binarySearch(arr, mid+1, high, elem);
         }
     }

     // We reach here when element is not present in array
     return -1;
 }

 // Driver method to test above
 public static void main(String args[])
 {
     BinarySearch ob = new BinarySearch();
     int arr[] = {2,3,4,10,40};
     int n = arr.length;
     int x = 10;
     int result = ob.binarySearch(arr,0,n-1,x);
     if (result == -1)
         System.out.println("Element not present");
     else
         System.out.println("Element found at index "+result);
 }
}
/* This code is contributed by Rajat Mishra */
