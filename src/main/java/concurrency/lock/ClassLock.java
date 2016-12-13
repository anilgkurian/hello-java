package concurrency.lock;

/**
 * 
 * @author Anil Kurian
 * Checks class lock and object lock
 */
public class ClassLock {

	public static void main(final String... args) {

		final MyClassThread t1 = new MyClassThread();

		final ClassLock lockOb = new ClassLock();
		final MyObjThread t2 = new MyObjThread(lockOb);
		final MyObjThread t3 = new MyObjThread(lockOb);

		t1.start();
		t2.start();
		t3.start();
	}

	private static class MyClassThread extends Thread {

		@Override
		public void run() {
			System.out.println(getName() + " is need Class Lock");
			synchronized (ClassLock.class) {
				System.out.println(getName() + " is running with Class Lock");
				try {
					sleep(3000);
				} catch (final InterruptedException e) {
				}
			}
		}
	}

	private static class MyObjThread extends Thread {

		private final ClassLock obj;

		public MyObjThread(final ClassLock ob) {
			obj = ob;
		}

		@Override
		public void run() {
			System.out.println(getName() + " is need Object Lock");
			synchronized (obj) {
				System.out.println(getName() + " is running with Object Lock");
				try {
					sleep(3000);
				} catch (final InterruptedException e) {
				}
			}
		}
	}

}
