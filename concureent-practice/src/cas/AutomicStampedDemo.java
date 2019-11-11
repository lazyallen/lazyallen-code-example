package cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 利用时间戳版本机制去解决了ABA问题
 * @author allen
 * @Date 2019-11-11
 */
public class AutomicStampedDemo {
	private static AtomicInteger atomicInteger = new AtomicInteger(100);
	private static AtomicStampedReference atomicStampedReference = new AtomicStampedReference(100,1);

	public static void main(String[] args) throws InterruptedException {
		Thread threadA = new Thread(() -> {
			atomicInteger.compareAndSet(100,101);
			atomicInteger.compareAndSet(101,100);
		});

		Thread threadAc = new Thread(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			boolean compareAndSet = atomicInteger.compareAndSet(100, 102);
			System.out.println("ABA isExist:"+compareAndSet);
		});

		threadA.start();
		threadAc.start();
		threadA.join();
		threadAc.join();


		Thread threadB = new Thread(() -> {
			atomicStampedReference.compareAndSet(100,101,atomicStampedReference.getStamp(),atomicStampedReference.getStamp() + 1);
			//获取不一样的时间戳
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			atomicStampedReference.compareAndSet(101,100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp() + 1);
		});

		Thread threadBc = new Thread(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			boolean compareAndSet = atomicStampedReference.compareAndSet(100, 102,atomicStampedReference.getStamp(),atomicStampedReference.getStamp() + 1);
			System.out.println("ABA isExist:"+compareAndSet);
		});



		threadB.start();
		threadBc.start();
		threadB.join();
		threadBc.join();




	}
}
