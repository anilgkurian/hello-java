package algorithm.general;

public class PrintPrimt {

	public static void main(String[] args) {

		long currentTimeMillis = System.currentTimeMillis();
		for(int i=Integer.MAX_VALUE/10;i>0;i--) {
			if(CheckPrime.checkPrime(i)){
//				System.out.println(i);
			}
		}
		System.out.println(System.currentTimeMillis() - currentTimeMillis);
	}
}
