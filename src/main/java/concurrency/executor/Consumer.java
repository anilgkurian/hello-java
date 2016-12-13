package concurrency.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

/**
 * @author Anil Kurian
 *
 */
public class Consumer implements Callable<String> {

	private final BlockingQueue<String> q;
	private final String name;

	public Consumer(final String name, final BlockingQueue<String> queue) {
		this.name = name;
		q = queue;
	}

	@Override
	public String call() {

		System.out.println(name + " is waiting...");
		try {
			final String take = q.take();
			System.out.println(name + " processing " + take);
			Thread.sleep(1000);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
		return name;
	}

}
