package thread;

/**
 * @author allen
 * @Date 2019-11-11
 */
public class RunableDemo {

	public static void main(String[] args) {

		new Thread(new MyRunnable()).start();

	}

	static class MyRunnable implements Runnable {
		@Override
		public void run() {
			System.out.println("i am runnable");
		}
	}
}
