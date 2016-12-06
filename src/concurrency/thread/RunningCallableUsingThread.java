package concurrency.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class RunningCallableUsingThread {

	public static void main(final String... strings) {

		final CallableObj callableObj = new CallableObj();
		// wraps its on FutureTask
		final FutureTask<String> futureTask = new FutureTask<>(callableObj);

		final Thread thread = new Thread(futureTask, "Callable with Thread");
		thread.start();
	}

	private static class CallableObj implements Callable<String> {

		@Override
		public String call() throws Exception {
			System.out.println(Thread.currentThread().getName());
			return Thread.currentThread().getName();
		}

	}
}
