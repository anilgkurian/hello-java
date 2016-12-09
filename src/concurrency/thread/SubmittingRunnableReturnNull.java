package concurrency.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Anil Kurian
 *
 */
public class SubmittingRunnableReturnNull {

	private static ExecutorService pool = Executors.newFixedThreadPool(3);

	public static void main(final String... strings) {

		final Future<?> submit = pool.submit(new RunnableObj());
		try {
			System.out.println("Result is " + submit.get());
		} catch (final Exception e) {
			e.printStackTrace();
		}

		pool.shutdownNow();
	}

	private static class RunnableObj implements Runnable {

		@Override
		public void run() {
			System.out.println("Task running");
			try {
				Thread.sleep(2000);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
