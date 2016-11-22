package oop;

public class AutoBoxing {

	
	public static void main(String[] arg) {
		test(2,3);
	}
	
	
	public static void test(int a, int b) {
		System.out.println("A");
	}
	
	public static void test(Integer a, Integer b) {
		System.out.println("B");
	}
	
}
