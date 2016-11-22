package concurrency.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class RunningCallableUsingThread {

	
	public static void main(String...strings ) {
		
		Task t  = new Task();
		FutureTask<String> task = new FutureTask<>(t);
		Thread th = new Thread(task,"Callable with Thread");
		th.start();
	}
	
	private static class Task implements Callable<String>{

		@Override
		public String call() throws Exception {
			System.out.println(Thread.currentThread().getName());
			return Thread.currentThread().getName();
		}
		
	}
}
