package concurrency.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

/**
 * @author Anil Kurian
 *
 */
public class Producer implements Callable<String> {

	private final BlockingQueue<String> q;
	private final String name;

	public Producer(final String name, final BlockingQueue<String> queue) {
		this.name = name;
		q = queue;
	}

	@Override
	public String call() throws Exception {
		System.out.println(name + " is running");
		try {
			Thread.sleep(1000);
			q.put("Task by " + name);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
		return "Task by " + name;
	}

}
