package concurrency.futureTask;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author Anil Kurian 
 * Submitted task will be running in a new thread
 * @param <V>
 */
public class MyExecutor<V> implements ExecutorService {

	@Override
	public <T> Future<T> submit(final Callable<T> task) {
		final MyFutureTask<T> future = new MyFutureTask<>(task);
		new Thread(future).start();
		return future;
	}

	@Override
	public void execute(final Runnable arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean awaitTermination(final long timeout, final TimeUnit unit) throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> List<Future<T>> invokeAll(final Collection<? extends Callable<T>> tasks) throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<Future<T>> invokeAll(final Collection<? extends Callable<T>> tasks, final long timeout,
			final TimeUnit unit) throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T invokeAny(final Collection<? extends Callable<T>> tasks)
			throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T invokeAny(final Collection<? extends Callable<T>> tasks, final long timeout, final TimeUnit unit)
			throws InterruptedException, ExecutionException, TimeoutException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isShutdown() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTerminated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Runnable> shutdownNow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<?> submit(final Runnable task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Future<T> submit(final Runnable task, final T result) {
		// TODO Auto-generated method stub
		return null;
	}

}