package concurrency.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShutdownPool {
	
	public static void main(String...strings ) {
		ExecutorService pool = Executors.newFixedThreadPool(3);
		
		pool.submit(new Runnable() {
			
			@Override
			public void run() {
				
			}
		});
		System.out.println("This program will never finish until you shutdown the pool");

	}

}
