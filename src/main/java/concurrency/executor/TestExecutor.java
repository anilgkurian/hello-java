package concurrency.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Using separate pools for Producers and Consumers. Using same pool can end up
 * in consumers occupying all the threads and waiting for producers to produce,
 * but producers will not get any threads to execute.
 *
 * @author Anil Kurian
 *
 */
public class TestExecutor {

	private static final int PRODUCER_POOL_SIZE = 5;

	private static final int CONSUMER_POOL_SIZE = 3;

	private static final int NO_OF_PRODUCERS = 10;

	private static final int NO_OF_CONSUMERS = 100;

	public static void main(final String[] args) {

		final MyPool<String> producerPool = new MyPool<>(PRODUCER_POOL_SIZE);

		final MyPool<String> consumerPool = new MyPool<>(CONSUMER_POOL_SIZE);

		final ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(30);

		for (int i = 0; i < NO_OF_PRODUCERS; i++) {
			final Producer producer = new Producer("Producer " + i, queue);
			producerPool.submit(producer);
		}

		for (int i = 0; i < NO_OF_CONSUMERS; i++) {
			final Consumer consumer = new Consumer("\t Consumer " + i, queue);
			final Future<String> future = consumerPool.submit(consumer);
			try {
				future.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
}
