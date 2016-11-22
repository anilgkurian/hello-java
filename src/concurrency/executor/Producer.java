package concurrency.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class Producer  implements Callable<String>{

	private BlockingQueue<String> q ;
	private String name  ;
	public Producer(String name, BlockingQueue<String> queue) {
		this.name = name;
		q = queue;
	}
	

	@Override
	public String call() throws Exception {
		System.out.println(name+ " is running");
		try {
			Thread.sleep(1000);
			q.put("Task by "+name);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Task by "+name;
	}

}
