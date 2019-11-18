package singleton;

/**
 * 饱汉 单线程安全 多线程下不安全
 * 不应该为final
 * @author allen
 * @Date 2019-11-18
 */
public class Singleton2 {
	private Singleton2 (){};
	private static Singleton2 INSTANCE = null;
	public static Singleton2 getInstance(){
		if (INSTANCE == null) {
			INSTANCE = new Singleton2();
		}
		return INSTANCE;
	}
}
