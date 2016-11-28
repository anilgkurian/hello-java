package concurrency.thread;

public class ThreadOddEven {

	
	static Integer count =0;
	
	public static void main(String[] args) {

		MyTask t1= new MyTask("t1");
		MyTask t2 =new MyTask("tttttttttt2");
		t1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
	}

	private static class MyTask extends Thread{
		
		public  MyTask(String name) {
			super(name);
		}
		
		@Override
		public void run() {
			synchronized (count) {
				while(count<100) {
					if(Thread.currentThread().getName().contains("1") && count%2==0){
						System.out.println(Thread.currentThread().getName()+":"+ count++);
					}else if(Thread.currentThread().getName().contains("2") && count%2!=0){
						System.out.println(Thread.currentThread().getName()+":"+ count++);
					}else {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
		
	}
}