package concurrency.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyPool<E> {

	private ExecutorService service;
	
	public MyPool(int number) {
		service = Executors.newFixedThreadPool(number);
	}
	
	public Future<E> submit(Callable<E> task) {
		return service.submit(task);
	}
}
