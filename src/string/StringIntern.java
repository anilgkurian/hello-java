package string;

/**
 * @author Anil Kurian
 *
 */
public class StringIntern {

	public static void main(final String... ar) {

		final String s = "anilgkurian";
		final String s2 = new String("anilgkurian").intern();

		System.out.println(s == s2);

	}
}
