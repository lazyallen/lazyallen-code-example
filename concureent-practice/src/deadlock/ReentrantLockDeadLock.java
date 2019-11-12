package deadlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author allen
 * @Date 2019-11-12
 */
public class ReentrantLockDeadLock {
	private static final ReentrantLock lock1 = new ReentrantLock();
	private static final ReentrantLock lock2 = new ReentrantLock();
	public static void main(String[] args) throws InterruptedException {
		Thread threadA = new Thread(() -> {
			lock1.lock();
			System.out.println("threadA got lock1 , ready to get lock2");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lock2.lock();
			System.out.println("threadA got lock2");
			lock2.unlock();

			lock1.unlock();
		});

		Thread threadB = new Thread(() -> {
			lock2.lock();
			System.out.println("threadB got lock2 , ready to get lock1");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lock1.lock();
			System.out.println("threadB got lock1");
			lock1.unlock();

			lock2.unlock();
		});

		threadA.start();
		threadB.start();

		threadA.join();
		threadB.join();
	}
}
