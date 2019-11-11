package threadlocal;

/**
 * @author allen
 * @Date 2019-11-11
 */
public class ThrealLocalDemo {
	private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
		@Override
		protected Integer initialValue() {
			return 0;
		}
	};

	public int countOne(){
		threadLocal.set(threadLocal.get()+1);
		return threadLocal.get();
	}


	public static void main(String[] args) {
		ThrealLocalDemo threalLocalDemo = new ThrealLocalDemo();

		ThrealLocalThread threalLocalThreadA = new ThrealLocalThread(threalLocalDemo);
		ThrealLocalThread threalLocalThreadB = new ThrealLocalThread(threalLocalDemo);
		ThrealLocalThread threalLocalThreadC = new ThrealLocalThread(threalLocalDemo);

		threalLocalThreadA.start();
		threalLocalThreadB.start();
		threalLocalThreadC.start();




	}

	static class ThrealLocalThread extends Thread {
		private ThrealLocalDemo threalLocalDemo;

		public ThrealLocalThread(ThrealLocalDemo threalLocalDemo) {
			this.threalLocalDemo = threalLocalDemo;
		}

		@Override
		public void run() {
			for (int i = 0; i< 3;i++){

				System.out.println(Thread.currentThread().getName()+"threalLocalDemo:"+threalLocalDemo.countOne());
			}
		}
	}



}

