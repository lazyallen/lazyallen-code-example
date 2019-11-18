package executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author allen
 * @Date 2019-11-13
 */
public class CountExecutors {
	//private Integer count = 0;
	private AtomicInteger count = new AtomicInteger(0);

	public static void main(String[] args) {
		CountExecutors countExecutors = new CountExecutors();
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 1000; i++){
			fixedThreadPool.execute(() -> {
				//ountExecutors.count++;
				countExecutors.count.incrementAndGet();
			});
		}
		System.out.println("CountExecutors count is :"+countExecutors.count);
		fixedThreadPool.shutdown();
	}
}
