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

	private static final int POOL_SIZE = 10;

	private static final int TASK_SIZE = 50;

	private static ExecutorService pool = Executors.newFixedThreadPool(POOL_SIZE);

	public static void main(final String... strings) {
		final Collection<Callable<String>> tasks = new ArrayList<Callable<String>>();
		for (int i = 1; i < TASK_SIZE; i++) {
			tasks.add(new Task("Task " + i));
		}
		try {

			final List<Future<String>> invokeAll = pool.invokeAll(tasks);
			System.out.println("Main is done");

			for (final Future<String> future : invokeAll) {
				try {
					if (future.isDone()) {
						System.out.println("Got result of " + future.get());
					}
				} catch (final ExecutionException e) {
					e.printStackTrace();
				}
			}

		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
		pool.shutdown();

	}

	private static class Task implements Callable<String> {

		private final String name;

		public Task(final String name) {
			this.name = name;
		}

		@Override
		public String call() throws Exception {
			System.out.println(name + " is running");
			try {
				Thread.sleep(1000);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " is done");
			return name;
		}

	}
}
