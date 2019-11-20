package printabc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author allen
 * @Date 2019-11-20
 */
public class PrintABCReentrantlock {
	static class Print{
		private ReentrantLock lock;
		Condition conditionA;
		Condition conditionB;
		Condition conditionC;

		public Print(ReentrantLock lock, Condition conditionA, Condition conditionB, Condition conditionC) {
			this.lock = lock;
			this.conditionA = conditionA;
			this.conditionB = conditionB;
			this.conditionC = conditionC;
		}

		void printA(Condition condition) throws InterruptedException {
			lock.lock();
			while (!condition.equals(conditionA)){
				conditionA.await();
			}
			System.out.println("A");
			conditionB.signal();
			lock.unlock();
		}

		void printB(Condition condition) throws InterruptedException {
			lock.lock();
			while (!condition.equals(conditionB)){
				conditionB.await();
			}
			System.out.println("B");
			conditionC.signal();
			lock.unlock();
		}

		void printC(Condition condition) throws InterruptedException {
			lock.lock();
			while (!condition.equals(conditionC)){
				conditionC.await();
			}
			System.out.println("C");
			conditionA.signal();
			lock.unlock();
		}

	}

	public static void main(String[] args) throws InterruptedException {
		final ReentrantLock reentrantLock = new ReentrantLock();
		Condition conditionA = reentrantLock.newCondition();
		Condition conditionB = reentrantLock.newCondition();
		Condition conditionC = reentrantLock.newCondition();
		Print print = new Print(reentrantLock,conditionA,conditionB,conditionC);

		Runnable printARunnable = () -> {
			try {
				print.printA(conditionA);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		Runnable printBRunnable = () -> {
			try {
				print.printB(conditionB);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		Runnable printCRunnable = () -> {
			try {
				print.printC(conditionC);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		Thread threadA = new Thread(printARunnable);
		Thread threadB = new Thread(printBRunnable);
		Thread threadC = new Thread(printCRunnable);

		threadA.start();
		Thread.sleep(1000);
		threadB.start();
		Thread.sleep(1000);
		threadC.start();

		threadA.join();
		threadB.join();
		threadC.join();



	}


}
