package string;

public class WordReverse {

	private static String sent = "anil g kurian aykara house";
	
	public static void main(String[] args) {
		String[] split = sent.split(" ");
		
		for(int i=split.length-1 ; i >=0 ; i--) {
			System.out.print(split[i] +" ");
		}
	}
}
