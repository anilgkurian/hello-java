package concurrency.futureTask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author Anil Kurian 
 * Executes the call() of the callable and blocks get() till
 *         its done
 * @param <V>
 */
public class MyFutureTask<V> implements Future<V>, Runnable {

	private V result;

	private final Callable<V> callable;

	private Boolean isDone = false;

	private final Object lock = new Object();

	public MyFutureTask(final Callable<V> callable) {
		this.callable = callable;
	}

	@Override
	public void run() {
		try {
			result = callable.call();
			synchronized (lock) {
				isDone = true;
				lock.notifyAll();
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean cancel(final boolean mayInterruptIfRunning) {
		if (mayInterruptIfRunning) {

		}
		return false;
	}

	@Override
	public V get() throws InterruptedException, ExecutionException {
		synchronized (lock) {
			while (!isDone) {
				lock.wait();
			}
		}
		return result;
	}

	@Override
	public V get(final long timeout, final TimeUnit unit)
			throws InterruptedException, ExecutionException, TimeoutException {
		return null;
	}

	@Override
	public boolean isCancelled() {
		return false;
	}

	@Override
	public boolean isDone() {
		synchronized (lock) {
			return isDone;
		}
	}

}
