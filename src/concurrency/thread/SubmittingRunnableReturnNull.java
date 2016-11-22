package concurrency.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmittingRunnableReturnNull {

	private static ExecutorService pool = Executors.newFixedThreadPool(3);

	public static void main(String... strings) {
		Future<?> submit = pool.submit(new Task());
		try {
			System.out.println("Result is " + submit.get());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static class Task implements Runnable {

		@Override
		public void run() {
			System.out.println("Task running");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
