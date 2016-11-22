package collections.array;

public class WordIndex {

	private static String input = "anil g my test string";

	private static String test = "test";

	public static void main(String... args) {

		char[] inp = input.toCharArray();
		char[] t = test.toCharArray();

		int j = 0;
		int index = -1;
		for (int i = 0; i < inp.length; i++) {

			if (inp[i] == t[j]) {
				if (j == 0) {
					index = i;
				}
				j++;
				if (j == t.length) {
					break;
				}
			} else {
				j = 0;
			}

		}

		if (j == 0) {
			index = -1;
		}
		System.out.println(index);

	}
}