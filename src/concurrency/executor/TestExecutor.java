package concurrency.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class TestExecutor {

	
	public static void main(String[] args) {
		
		
		MyPool<String> p1 = new MyPool<>(10);
		
		MyPool<String> p2 = new MyPool<>(3);
		
		ArrayBlockingQueue<String> q = new ArrayBlockingQueue<>(30);
		
		for(int i=0; i<10;i++) {
			Producer p = new Producer("Producer "+i, q);
			Future<String> submit = p1.submit(p);
		}
		
		for(int i=0; i<100;i++) {
			Consumer p = new Consumer("\t Consumer "+i, q);
			Future<String> submit = p2.submit(p);
			try {
				submit.get();
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
