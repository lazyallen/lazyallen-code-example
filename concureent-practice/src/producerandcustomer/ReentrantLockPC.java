package producerandcustomer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author allen
 * @Date 2019-11-12
 */
public class ReentrantLockPC {

	private static final ReentrantLock reentrantLock = new ReentrantLock();
	private static Condition condition = reentrantLock.newCondition();


	public static void main(String[] args) throws InterruptedException {
		Producer producer = new Producer(reentrantLock,condition);
		Consumer consumer = new Consumer(reentrantLock,condition);


		Thread produceThread = new Thread(() -> {
			for (int i=0;i<10;i++){
				try {
					producer.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});


		Thread consumeThread = new Thread(() -> {
			for (int i=0;i<10;i++){
				try {
					consumer.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		produceThread.start();
		consumeThread.start();

		produceThread.join();
		consumeThread.join();

	}

	static class Producer{
		private ReentrantLock reentrantLock;
		private Condition condition;

		public Producer(ReentrantLock reentrantLock, Condition condition) {
			this.reentrantLock = reentrantLock;
			this.condition = condition;
		}

		void produce() throws InterruptedException {
			reentrantLock.lock();
			if (!MyBuffer.value.equals("")) {
				condition.await();
			}
			String randomStr = String.valueOf(Math.random() * 10) ;
			MyBuffer.value = randomStr;
			System.out.println("producer produce value:"+randomStr);
			condition.signalAll();
			reentrantLock.unlock();
		}
	}

	static class Consumer {
		private ReentrantLock reentrantLock;
		private Condition condition;

		public Consumer(ReentrantLock reentrantLock, Condition condition) {
			this.reentrantLock = reentrantLock;
			this.condition = condition;
		}

		void consume() throws InterruptedException {
			reentrantLock.lock();
			if (MyBuffer.value.equals("")) {
				condition.await();
			}
			System.out.println("consumer consume value:"+MyBuffer.value);
			MyBuffer.value = "";
			condition.signalAll();
			reentrantLock.unlock();
		}
	}
}
