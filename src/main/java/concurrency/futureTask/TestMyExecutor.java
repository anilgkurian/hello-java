package concurrency.futureTask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @author Anil Kurian
 *
 */
public class TestMyExecutor {

	public static void main(final String[] args) {
		final ExecutorService pool = new MyExecutor<Integer>();
		final Future<String> future = pool.submit(new MyTask());

		System.out.println("Type of future is " + future.getClass().getName());

		try {
			System.out.println("Result is " + future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	private static class MyTask implements Callable<String> {

		@Override
		public String call() throws Exception {
			Thread.sleep(2000);
			return "MY TASK OUTPUT";
		}

	}

}
