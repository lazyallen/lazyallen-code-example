package deadlock;

import java.util.concurrent.TimeUnit;

/**
 * @author allen
 * @Date 2019-11-12
 */
public class SynchronizedDeadLock {
	private static final Object lock1 = new Object();
	private static final Object lock2= new Object();
	public static void main(String[] args) throws InterruptedException {

		Thread threadA = new Thread(() -> {
			synchronized (lock1) {
				System.out.println("threadA got lock1,ready to get lock2");
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock2){
					System.out.println("threadA got lock2");
				}
			}
		});

		Thread threadB = new Thread(() -> {
			synchronized (lock2) {
				System.out.println("threadB got lock2,ready to get lock1");
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock1){
					System.out.println("threadB got lock1");
				}
			}
		});

		threadA.start();
		threadB.start();

		threadA.join();
		threadB.join();



	}
}
