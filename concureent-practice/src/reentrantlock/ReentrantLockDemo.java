package reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 在Java语言层面实现管程
 * @author allen
 * @Date 2019-11-10
 */
public class ReentrantLockDemo {
	public static void main(String[] args) throws InterruptedException {

		ReentrantLock reentrantLock = new ReentrantLock();
		//条件变量，一个reentrantLock可以创建多个条件变量
		Condition condition = reentrantLock.newCondition();

		Thread threadA = new Thread(() -> {
			reentrantLock.lock();
			System.out.println("threadA is running");
			try {
				System.out.println("threadA is ready in to condition queue");
				condition.await();
				System.out.println("threadA is out from condition queue");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			reentrantLock.unlock();

		});

		Thread threadB = new Thread(() -> {
			reentrantLock.lock();
			System.out.println("threadB is running");
			condition.signal();
			System.out.println("threadB is ready unlock");
			reentrantLock.unlock();

		});

		threadA.start();
		threadB.start();
		threadA.join();
		threadB.join();


	}

}
