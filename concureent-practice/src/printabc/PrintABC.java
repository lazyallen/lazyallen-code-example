package printabc;

/**
 * 对象 -> 任务 -> 提交给线程执行
 * @author allen
 * @Date 2019-11-20
 */
public class PrintABC {
	static class Print{
		synchronized void printA(String flag) throws InterruptedException {
			while (!flag.equals("A")){
				wait();
			}
			System.out.println(Thread.currentThread()+"A");
			notifyAll();
		}

		synchronized void printB(String flag) throws InterruptedException {
			while (!flag.equals("B")){
				wait();
			}
			System.out.println(Thread.currentThread()+"B");
			notifyAll();
		}

		synchronized void printC(String flag) throws InterruptedException {
			while (!flag.equals("C")){
				wait();
			}
			System.out.println(Thread.currentThread()+"C");
			notifyAll();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Print print = new Print();
		Runnable printARunnable = ()-> {
			try {
				print.printA("A");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		Runnable printBRunnable = ()-> {
			try {
				print.printB("B");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		Runnable printCRunnable = ()-> {
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
