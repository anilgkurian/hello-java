package string;

/**
 * @author Anil Kurian
 *
 */
public class WordReverse {

	private static String sent = "anil g kurian code";

	public static void main(final String[] args) {
		final String[] split = sent.split(" ");

		for (int i = split.length - 1; i >= 0; i--) {
			System.out.print(split[i] + " ");
		}
	}
}
