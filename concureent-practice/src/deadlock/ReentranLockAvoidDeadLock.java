package deadlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 避免死锁的就是要去解除永久相互等待的关系，总要有一个让步
 * 有三种方式，这三种方式体现在Lock接口中
 * 1、非阻塞的获取锁[tryLock()]：意思是获取不到锁不要让自己进入阻塞你状态，而是立即返回，
 * 这样可以有机会释放已持有的锁，让另外一个进程可以得到想持有的锁。比如下面的例子中，
 * threadA 等到获取lock2失败返回false,进而执行lock1.unlock();释放lock1,从而让ThreadB获取了lock1，成功让步
 * 2、超时返回[tryLock(10, TimeUnit.SECONDS)]：就是等一段时间，要是超时了，也返回。属于非阻塞等待
 * 3、中断返回[lockInterruptibly()]：可以一直等，等待有别的线程去中断他，从而释放锁，让其他线程有机会获取想要持有的锁。
 * @author allen
 * @Date 2019-11-12
 */
public class ReentranLockAvoidDeadLock {
	private static final ReentrantLock lock1 = new ReentrantLock();
	private static final ReentrantLock lock2 = new ReentrantLock();
	public static void main(String[] args) throws InterruptedException {
		Thread threadA = new Thread(() -> {
			if (lock1.tryLock()) {
				System.out.println("threadA got lock1 , ready to get lock2");
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (lock2.tryLock()) {
					System.out.println("threadA got lock2");
					lock2.unlock();
				}


				lock1.unlock();
			}

		});

		Thread threadB = new Thread(() -> {
			if (lock2.tryLock()) {
				System.out.println("threadB got lock2 , ready to get lock1");
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (lock1.tryLock()) {
					System.out.println("threadB got lock1");
					lock1.unlock();
				}


				lock2.unlock();
			}

		});

		threadA.start();
		threadB.start();

		threadA.join();
		threadB.join();
	}
}
