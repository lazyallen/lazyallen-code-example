package executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author allen
 * @Date 2019-11-12
 */
public class ExecutorsDemo {

	public static void main(String[] args) {

		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);

		//execute一次提交一个任务
		fixedThreadPool.execute(() -> {
			System.out.println("hello,i am "+Thread.currentThread().getName());
		});
		fixedThreadPool.execute(() -> {
			System.out.println("hello,i am "+Thread.currentThread().getName());
		});



		fixedThreadPool.shutdown();

	}
}
