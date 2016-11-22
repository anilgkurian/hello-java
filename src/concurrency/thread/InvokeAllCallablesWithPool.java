package concurrency.thread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InvokeAllCallablesWithPool {

	private static ExecutorService pool = Executors.newFixedThreadPool(3);
	
	public static void main(String...strings ) {
		Collection<Callable<String>> tasks = new ArrayList<Callable<String>>();
		for(int i=0;i<3;i++) {
			tasks.add(new Task("T "+i));
		}
		try {
			
			List<Future<String>> invokeAll = pool.invokeAll(tasks);
			System.out.println("Main is done");
			
			for(Future<String> future : invokeAll) {
				try {
					System.out.println(future.get());
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace(); 
		}
		pool.shutdown();

	}
	
	private static class Task implements Callable<String>{
		
		private String name;
		
		public Task(String name) {
			this.name = name;
		}

		@Override
		public String call() throws Exception {
			System.out.println(name+ " is running");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " is done");
			return name;
		}

		
	}
}
