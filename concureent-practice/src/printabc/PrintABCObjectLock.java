package printabc;

/**
 * @author allen
 * @Date 2019-11-20
 */
public class PrintABCObjectLock {
	static class Print{
		private Object lock;

		public Print(Object lock) {
			this.lock = lock;
		}

		void printA(String flag) throws InterruptedException {
			synchronized (lock){
				while (!"A".equals(flag)){
					lock.wait();
				}
				System.out.println("A");
				lock.notifyAll();
			}
		}

		void printB(String flag) throws InterruptedException {
			synchronized (lock){
				while (!"B".equals(flag)){
					lock.wait();
				}
				System.out.println("B");
				lock.notifyAll();
			}
		}

		void printC(String flag) throws InterruptedException {
			synchronized (lock){
				while (!"C".equals(flag)){
					lock.wait();
				}
				System.out.println("C");
				lock.notifyAll();
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		final Object lock = new Object();
		Print print = new Print(lock);

		Runnable printARunnable = () -> {
			try {
				print.printA("A");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		Runnable printBRunnable = () -> {
			try {
				print.printB("B");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		Runnable printCRunnable = () -> {
			try {
				print.printC("C");
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
