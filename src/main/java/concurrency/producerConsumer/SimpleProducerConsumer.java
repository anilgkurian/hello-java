package concurrency.producerConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Anil Kurian
 *
 */
public class SimpleProducerConsumer {

	private static BlockingQueue<String> queue = new LinkedBlockingQueue<>();

	public static void main(final String[] ar) {
		final Producer producer = new Producer(queue);
		new Thread(producer, "Producer").start();

		for (int i = 0; i < 3; i++) {
			final Consumer consumer = new Consumer(queue);
			new Thread(consumer, "Consumer-" + i).start();
		}
	}

	private static class Producer implements Runnable {

		private final BlockingQueue<String> queue;

		private static int count; // no sync, only for printing

		Producer(final BlockingQueue<String> q) {
			queue = q;
		}

		@Override
		public void run() {
			while (true) {
				try {
					queue.put(produce());
				} catch (final InterruptedException e) {
				}
			}
		}

		private String produce() throws InterruptedException {
			try {
				Thread.sleep(10);
			} catch (final InterruptedException e) {
				throw e;
			}
			System.out.println("producing " + count++);
			return count + "";
		}

	}

	private static class Consumer implements Runnable {

		private final BlockingQueue<String> queue;

		Consumer(final BlockingQueue<String> q) {
			queue = q;
		}

		@Override
		public void run() {
			while (true) {
				try {
					System.out.println(Thread.currentThread().getName() + " processed " + queue.take());
				} catch (final InterruptedException e) {
				}
			}
		}

	}
}
