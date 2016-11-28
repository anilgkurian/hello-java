package datastructure.map;
import java.util.HashMap;
import java.util.Map;

public class DuplicateInArray {

	private static int[] array = new int[]{1,32,4,6,3,4,1,2,34,5,5,5,4};
	
	
	public static void main(String... args) {
		
		findDuplicateUsingMap();
		printRepeatingUsingArray();
	}


	private static void findDuplicateUsingMap() {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		for(int i: array) {
			Integer number = map.get(i);
			map.put(i, number==null?1:++number);
		}
		
		for(int i:map.keySet()) {
			Integer integer = map.get(i);
			if(integer>1) {
				System.out.println(i + " : no. of duplicates "+map.get(i));
			}
		}
	}
	
	
	private static void printRepeatingUsingArray() 
    {
		
		int size = getMaxNum(array);
		System.out.println("max is " + size);
        int count[] = new int[size];
        int i;
 
        System.out.println("Repeated elements are : ");
        for (i = 0; i < array.length; i++) 
        {
            if (count[array[i]] == 1) {
                System.out.print(array[i] + " ");
                count[array[i]]=0;
            }
            else
                count[array[i]]=count[array[i]]+1;
        }
    }
	
	private static int getMaxNum(int arr[]) {
		int num = arr[0];
		
		for(int i=0;i<arr.length;i++) {
			if(num<arr[i]) {
				num = arr[i];
			}
		}
		return num+1;
	}
}
