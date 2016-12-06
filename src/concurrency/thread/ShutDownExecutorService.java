package concurrency.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ShutDownExecutorService {

	public static void main(final String... strings) {

		final ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

		// pool is not shut down
		System.out.println(newCachedThreadPool.isTerminated());

		newCachedThreadPool.shutdown();

		try {
			System.out.println(newCachedThreadPool.awaitTermination(10, TimeUnit.SECONDS));
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
	}
}
