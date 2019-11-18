package singleton;

/**
 * @author allen
 * @Date 2019-11-18
 */
public class SingletonDemo {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}

	private static void test4() {
		SingletonEnum instance1 = SingletonEnum.SINGLETON;
		SingletonEnum instance2 = SingletonEnum.SINGLETON;
		System.out.println(instance1 == instance2);
	}

	private static void test3() {
		Singleton3 instance1 = Singleton3.getInstance();
		Singleton3 instance2 = Singleton3.getInstance();
		System.out.println(instance1 == instance2);
	}


	private static void test2() {
		Singleton2 instance1 = Singleton2.getInstance();
		Singleton2 instance2 = Singleton2.getInstance();
		System.out.println(instance1 == instance2);
	}

	private static void test1() {
		Singleton1 instance1 = Singleton1.getInstance();
		Singleton1 instance2 = Singleton1.getInstance();
		System.out.println(instance1 == instance2);
	}
}
