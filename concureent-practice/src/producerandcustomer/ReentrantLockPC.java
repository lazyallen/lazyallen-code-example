package producerandcustomer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
		//任务
		Runnable produceRunnable = () -> {
			for (int i=0;i<10;i++){
				try {
					producer.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Runnable consumerRunnable = () -> {
			for (int i=0;i<10;i++){
				try {
					consumer.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		//线程
//		Thread produceThread = new Thread(produceRunnable);
//		Thread consumeThread = new Thread(consumerRunnable);
//		produceThread.start();
//		consumeThread.start();
//		produceThread.join();
//		consumeThread.join();

		//线程池
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
		fixedThreadPool.execute(produceRunnable);
		fixedThreadPool.execute(consumerRunnable);


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
