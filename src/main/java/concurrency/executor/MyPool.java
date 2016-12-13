package concurrency.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Anil Kurian
 *
 * @param <E>
 */
public class MyPool<E> {

	private final ExecutorService service;

	public MyPool(final int number) {
		service = Executors.newFixedThreadPool(number);
	}

	public Future<E> submit(final Callable<E> task) {
		return service.submit(task);
	}
}
