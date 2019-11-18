package singleton;

/**
 * 饿汉 线程安全 在类加载的时候初始化一次，且类加载是线程安全的
 * @author allen
 * @Date 2019-11-18
 */
public class Singleton1 {
	private Singleton1(){};
	private static final Singleton1 INSTANCE = new Singleton1();
	public static Singleton1 getInstance(){
		return INSTANCE;
	}
}
