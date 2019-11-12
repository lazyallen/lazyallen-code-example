package producerandcustomer;

/**
 * @author allen
 * @Date 2019-11-11
 */
public class SynchronizedPC {



	public static void main(String[] args) {
		final Object lock = new Object();
		Producer producer = new Producer(lock);
		Consumer consumer = new Consumer(lock);
		/**
		 * 两个工作线程各自调度任务10次
		 */
		Thread producerThread = new Thread(() -> {
			for (int i = 0;i < 10;i++){
				producer.produce();
			}
		});
		Thread customerThread = new Thread(() -> {
			for (int i = 0;i < 10;i++){
				consumer.consume();
			}
		});

		producerThread.start();
		customerThread.start();

	}

	/**
	 * 生产者 任务
	 */
	static class Producer {

		private Object lock;

		public Producer(Object lock) {
			this.lock = lock;
		}

		public void produce(){
			synchronized (lock) {
				if (!MyBuffer.value.equals("")) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				MyBuffer.value = String.valueOf(Math.random() * 10);
				System.out.println("producer produce value:"+MyBuffer.value);

				lock.notifyAll();
			}
		}
	}

	/**
	 * 消费者 任务
	 */
	static class Consumer {
		private Object lock;

		public Consumer(Object lock) {
			this.lock = lock;
		}

		public void consume(){
			synchronized (lock) {
				if (MyBuffer.value.equals("")) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("customer custom value"+MyBuffer.value);
				MyBuffer.value = "";
				lock.notifyAll();
			}
		}
	}

}
