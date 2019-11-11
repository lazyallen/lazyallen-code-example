package synchro9zied;

/**
 * 在Jvm层面实现管程规范
 * @author allen
 * 一组线程在争夺共享资源时，互相等待对方释放所持有的锁，从而造成永久等待的情况。
 * @Date 2019-11-07
 */
public class DeadLock {


	public static void main(String[] args) throws InterruptedException {

		final Object lock1 = new Object();
		final Object lock2 = new Object();

		Thread threadA = new Thread(() -> {
			synchronized (lock1) {
				System.out.println(Thread.currentThread().getName()+"获取了lock1");
				synchronized (lock2){
					System.out.println(Thread.currentThread().getName()+"获取了lock2");

				}
			}
		});

		Thread threadB = new Thread(() -> {
			synchronized (lock2) {
				System.out.println(Thread.currentThread().getName()+"获取了lock2");
				synchronized (lock1){
					System.out.println(Thread.currentThread().getName()+"获取了lock1");

				}
			}
		});

		threadA.start();
		threadB.start();

		threadA.join();
		threadB.join();





	}

}
