package concurrency.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class Consumer  implements Callable<String>{

	private BlockingQueue<String> q ;
	private String name  ;
	
	public Consumer(String name, BlockingQueue<String> queue) {
		this.name = name;
		q = queue;
	}
	
	@Override
	public String call() {

		System.out.println(name + " is waiting...");
		try {
			String take = q.take();
			System.out.println(name+ " processing "+take);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return name;
	}

}
