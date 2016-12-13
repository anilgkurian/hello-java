package concurrency.thread;

public class ThreadOddEvenUsingSleep {

	static Integer count = 0;

	public static void main(final String[] args) {

		final MyTask thread1 = new MyTask("thread 1");
		final MyTask thread2 = new MyTask("thread 2 ************");
		thread1.start();
		try {
			Thread.sleep(1000);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
		thread2.start();
	}

	private static class MyTask extends Thread {

		public MyTask(final String name) {
			super(name);
		}

		@Override
		public void run() {
			synchronized (count) {
				while (count < 100) {
					if (Thread.currentThread().getName().contains("1") && ((count % 2) == 0)) {
						System.out.println(Thread.currentThread().getName() + ":" + count++);
					} else if (Thread.currentThread().getName().contains("2") && ((count % 2) != 0)) {
						System.out.println(Thread.currentThread().getName() + ":" + count++);
					} else {
						try {
							Thread.sleep(100); // hack
						} catch (final InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}

	}
}
