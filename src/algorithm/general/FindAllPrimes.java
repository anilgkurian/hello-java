package algorithm.general;

public class FindAllPrimes {

	public static void main(final String[] args) {

		final long currentTimeMillis = System.currentTimeMillis();
		for (int i = Integer.MAX_VALUE / 10; i > 0; i--) {
			if (CheckPrime.isPrime(i)) {
				// System.out.println(i);
			}
		}
		System.out.println(System.currentTimeMillis() - currentTimeMillis);
	}
}
