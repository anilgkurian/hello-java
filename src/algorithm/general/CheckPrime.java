package algorithm.general;

public class CheckPrime {

	public static void main(String[] args) {
		System.out.println(isPrime(Integer.MAX_VALUE));
	}

	public  static boolean isPrime(int x){
        // convert to decimal
        // check if mod is
        if (x ==2 ) return true;
	
        for(int i =2; i <= Math.sqrt(x); i++ )
            if (x %i == 0) {
                return false ;
            }
        return true;

    }
}
