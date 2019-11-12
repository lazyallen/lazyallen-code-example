package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author allen
 * @Date 2019-11-11
 */
public class CallableDemo {
	public static void main(String[] args) throws ExecutionException, InterruptedException {

		MyCallable myCallable = new MyCallable("callable");

		FutureTask<String> myTask = new FutureTask<>(myCallable);

		new Thread(myTask).start();

		System.out.println("hello :"+myTask.get());

	}

	static class MyCallable implements Callable<String> {

		private String str;

		public MyCallable(String str) {
			this.str = str;
		}

		@Override
		public String call() throws Exception {
			return this.str;
		}
	}
}
