package singleton;

/**饱汉 多线程安全 volatile 禁止指令重排 双重校验 保证了多线程环境下的安全
 * @author allen
 * @Date 2019-11-18
 */
public class Singleton3 {
	private Singleton3(){};
	private static volatile Singleton3 INSTANCE = null;
	public static Singleton3 getInstance(){
		if (INSTANCE == null) {
			synchronized (Singleton3.class){
				if (INSTANCE == null) {
					INSTANCE = new Singleton3();
				}
			}
		}
		return INSTANCE;
	}


}
