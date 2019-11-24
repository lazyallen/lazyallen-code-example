package singleton;

/**饱汉 多线程安全 volatile 禁止指令重排 双重校验 保证了多线程环境下的安全
 * @author allen
 * @Date 2019-11-18
 */
public class Singleton3 {
	private Singleton3(){};
	//volate 禁止指令重排 防止NPE
	private static volatile Singleton3 INSTANCE = null;
	public static Singleton3 getInstance(){
		//第一层就判空，为了性能
		if (INSTANCE == null) {
			//加锁 保证线程安全
			synchronized (Singleton3.class){
				//保证两个线程同时调用getInstance方法时，new出两个不同的对象
				if (INSTANCE == null) {
					INSTANCE = new Singleton3();
				}
			}
		}
		return INSTANCE;
	}


}
