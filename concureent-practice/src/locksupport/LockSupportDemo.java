package locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @author allen
 * @Date 2019-11-10
 */
public class LockSupportDemo {
	public static void main(String[] args) throws InterruptedException {
		Thread threadA = new Thread(() -> {
			LockSupport.park("this is threadA lock blocker");
			System.out.println("i am wake now by threadB");
		});

		threadA.start();


		Thread.sleep(1000);

		Thread threadB = new Thread(() -> {
			String before = (String)LockSupport.getBlocker(threadA);
			System.out.println("before unpark Thread A,block is :"+before);
			LockSupport.unpark(threadA);
			try {
				//保证threadA已经被唤醒
				Thread.sleep(1000);
				String after = (String)LockSupport.getBlocker(threadA);
				System.out.println("after unpark Thread A,block is :"+after);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		});
		threadB.start();

		threadA.join();
		threadB.join();

	}
}
