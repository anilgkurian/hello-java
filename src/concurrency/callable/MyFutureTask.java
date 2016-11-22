package concurrency.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MyFutureTask<V> implements Future<V>, Runnable{

	private V result;
	
	private Callable<V> callable;
	
	private Boolean isDone = false;
	
	private Object lock = new Object();
	
	public MyFutureTask(Callable<V> callable) {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean cancel(boolean mayInterruptIfRunning) {
		if(mayInterruptIfRunning){
			
		}
		return false;
	}

	@Override
	public V get() throws InterruptedException, ExecutionException {
		synchronized (lock) {
			while(!isDone) {
				lock.wait();
			}
		}
		return result;
	}

	@Override
	public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
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
