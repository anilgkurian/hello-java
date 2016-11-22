package concurrency.prodConsume;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SimpleProdCons {

	static BlockingQueue<String> q = new LinkedBlockingQueue<>();

	public static void main(String[] ar) {
		Producer t = new Producer(q);
		new Thread(t).start();
		
		for (int i = 0; i < 3; i++) {
			Consumer t1 = new Consumer(q);
			new Thread(t1).start();
		}
	}

	private static class Producer implements Runnable {
		BlockingQueue<String> q;

		Producer(BlockingQueue<String> q) {
			this.q = q;
		}

		@Override
		public void run() {
			while (true) {
				try {
					q.put(produce());
				} catch (InterruptedException e) {
				}
			}
		}

		static int i;

		private String produce() {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("producing " + i++);
			return i + "";
		}

	}

	private static class Consumer implements Runnable {
		BlockingQueue<String> q;

		Consumer(BlockingQueue<String> q) {
			this.q = q;
		}

		@Override
		public void run() {
			try {
				System.out.println(Thread.currentThread().getName() + " Processed " + q.take());
			} catch (InterruptedException e) {
			}
		}

	}
}
