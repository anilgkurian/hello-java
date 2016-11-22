package concurrency.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChachedTreadPool {

	public static void main(String...strings ) {
		
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		
		newCachedThreadPool.submit(new Runnable() {
			
			@Override
			public void run() {
				
			}
		});
		
		
		System.out.println(newCachedThreadPool.isTerminated());
		
		
	}
}
