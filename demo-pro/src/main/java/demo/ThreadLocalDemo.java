package demo;

/**
 * Created by zhoupanchn on 2020/3/3.
 */
public class ThreadLocalDemo {
    public static ThreadLocal<String> da = new ThreadLocal<>();

    public static void set(String name) {
        da.set(name);
    }

    public static String get() {
        return da.get();
    }
}
