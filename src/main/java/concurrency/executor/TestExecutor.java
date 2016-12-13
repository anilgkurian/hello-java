package concurrency.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author Anil Kurian
 *
 */
public class TestExecutor {

	public static void main(final String[] args) {

		final MyPool<String> p1 = new MyPool<>(10);

		final MyPool<String> p2 = new MyPool<>(3);

		final ArrayBlockingQueue<String> q = new ArrayBlockingQueue<>(30);

		for (int i = 0; i < 10; i++) {
			final Producer p = new Producer("Producer " + i, q);
			p1.submit(p);
		}

		for (int i = 0; i < 100; i++) {
			final Consumer p = new Consumer("\t Consumer " + i, q);
			final Future<String> submit = p2.submit(p);
			try {
				submit.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
}
