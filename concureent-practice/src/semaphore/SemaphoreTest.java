package semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author allen
 * @Date 2019-11-07
 */
public class SemaphoreTest {
	public static void main(String[] args) {
		Parking parking = new Parking(3);

		for (int i = 0; i < 5 ; i++){
			Car car = new Car(parking);
			car.start();
		}

	}

	static class Parking {
		private Semaphore semaphore;

		public Parking(int count) {
			this.semaphore = new Semaphore(count);
		}

		public void park(){
			try {
				semaphore.acquire();
				long parkTime = (long)(Math.random() * 10);
				System.out.println(Thread.currentThread().getName()+"已经进入停车场");
				Thread.sleep(parkTime);
				System.out.println(Thread.currentThread().getName()+"已经出了停车场");
			}catch (Exception e) {
				System.out.println("异常"+e);
			}finally {
				semaphore.release();
			}
		}
	}

	static class Car extends Thread {
		private Parking parking;

		public Car(Parking parking) {
			this.parking = parking;
		}

		@Override
		public void run() {
			parking.park();
		}
	}


}
