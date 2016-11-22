package concurrency.lock;

public class ClassLock {

	public static void main(String... args) {

		MyClassThread t1 = new MyClassThread();
		MyObjThread t2 = new MyObjThread(new ClassLock());

		t1.start();
		t2.start();

	}

	private static class MyClassThread extends Thread {

		@Override
		public void run() {
			synchronized (ClassLock.class) {
				System.out.println(getName() + " is running");
				try {
					sleep(3000);
				} catch (InterruptedException e) {
				}
			}
		}
	}

	private static class MyObjThread extends Thread {

		private ClassLock obj;

		public MyObjThread(ClassLock ob) {
			this.obj = ob;
		}

		@Override
		public void run() {
			synchronized (obj) {
				System.out.println(getName() + " is running");
				try {
					sleep(3000);
				} catch (InterruptedException e) {
				}
			}
		}
	}

}
